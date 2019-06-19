package pvet.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

public class Cita {
    private int idcita;
    private Mascota a;
    private Empleado e;
    private String tipocita;
    private Date fecha;
    private int pago;
    
    public Cita(){
    }
    public Cita(int idcita, Mascota a, Empleado e, String tipocita, Date fecha, int pago){
        this.idcita=idcita;
        this.a=a;
        this.e=e;
        this.tipocita=tipocita;
        this.fecha=fecha;
        this.pago=pago;
    }

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    
    
    public String getTipocita() {
        return tipocita;
    }

    public void setTipocita(String tipocita) {
        this.tipocita = tipocita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }
    
    
    public Mascota getA() {
        return a;
    }

    public void setA(Mascota a) {
        this.a = a;
    }

    public Empleado getE() {
        return e;
    }

    public void setE(Empleado e) {
        this.e = e;
    }
  
    public int agregarCita(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("INSERT INTO cita (mascota_idmascota, empleado_idempleado, tipocita, fecha, pago) VALUES (?, ?, ?, ?, ?)");
            instruccion.setInt(1, a.getId());
            instruccion.setInt(2, e.getIde());
            instruccion.setString(3, tipocita);
            instruccion.setDate(4, fecha);
            instruccion.setInt(5, pago);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int eliminarCita(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("DELETE FROM cita WHERE idcita = ?");
            instruccion.setInt(1, idcita);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int editarCitas(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("UPDATE cita SET datosm = ?, datose = ?, tipocita = ?, fecha = ?, pago = ? WHERE idcita = ?");
            instruccion.setString(1, a.getMascota());
            instruccion.setString(2, e.getEmpleado());
            instruccion.setString(3, tipocita);
            instruccion.setDate(4, fecha);
            instruccion.setInt(5, pago);
            instruccion.setInt(6, idcita);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
        
    public static void almacenarInfoC(Connection conn, ObservableList<Cita> lista){
            try{
                Statement sta = conn.createStatement();
                ResultSet resultado = sta.executeQuery("SELECT idcita, nMascota, empleado, tipocita, fecha, pago " +
                    "FROM cita " +
                    "INNER JOIN mascota " +
                    "ON (idmascota = mascota_idmascota) " +
                    "INNER JOIN empleado " +
                    "ON (idempleado = empleado_idempleado)");
                while(resultado.next()){
                    lista.add(new Cita(resultado.getInt("idcita"), new Mascota(resultado.getString("nMascota")), new Empleado(resultado.getString("empleado")), resultado.getString("tipocita"), resultado.getDate("fecha"), resultado.getInt("pago"))); 
                }
            }catch(SQLException e){ 
                e.printStackTrace();
            }
    }
}
