package pvet.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

public class Venta {
    private int idventa;
    private Date fechaven;
    private Empleado em;
    private Articulo ar;
    private int cant;

    public Venta(){
    }
    public Venta(int idventa, Articulo ar, Empleado em, Date fechaven, int cant){
        this.idventa=idventa;
        this.ar=ar;
        this.em=em;
        this.fechaven=fechaven;
        this.cant=cant;
    }
    
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Date getFechaven() {
        return fechaven;
    }

    public void setFechaven(Date fechaven) {
        this.fechaven = fechaven;
    }

    public Empleado getEm() {
        return em;
    }
    public void setEm(Empleado em) {
        this.em = em;
    }
    public Articulo getAr() {
        return ar;
    }
    public void setAr(Articulo ar) {
        this.ar = ar;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    
    public int agregarVentas(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("INSERT INTO venta (articulo_idarticulo, empleado_idempleado, fecha, canti) VALUES (?, ?, ?, ?)");
            instruccion.setInt(1, ar.getIda());
            instruccion.setInt(2, em.getIde());
            instruccion.setDate(3, fechaven);
            instruccion.setInt(4, cant);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int eliminarVentas(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("DELETE FROM venta WHERE idventa = ?");
            instruccion.setInt(1, idventa);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int editarVentas(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("UPDATE venta SET articuloventa = ?, empleadoventa = ?, fecha = ?, canti = ? WHERE idventa = ?");
            instruccion.setString(1, ar.getArtic());
            instruccion.setString(2, em.getEmpleado());
            instruccion.setDate(4, fechaven);
            instruccion.setInt(5, cant);
            instruccion.setInt(6, idventa);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    public static void almacenarInfoV(Connection conn, ObservableList<Venta> lista){
            try{
                Statement sta = conn.createStatement();
                ResultSet resultado = sta.executeQuery("SELECT idventa, arti, empleado, fecha, canti " +
                "FROM venta " +
                "INNER JOIN articulo " +
                "ON (idarticulo = articulo_idarticulo) " +
                "INNER JOIN empleado " +
                "ON (idempleado = empleado_idempleado)");
                while(resultado.next()){
                    lista.add(new Venta(resultado.getInt("idventa"), new Articulo(resultado.getString("arti")), new Empleado(resultado.getString("empleado")), resultado.getDate("fecha"), resultado.getInt("canti"))); 
                }
            }catch(SQLException e){ 
                e.printStackTrace();
            }
    } 
}
