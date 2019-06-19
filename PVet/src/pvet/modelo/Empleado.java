package pvet.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

public class Empleado {
    private int ide;
    private String empleado;
    private String contrasenia;
    private int telefono;
    private String direccion;
    private String sexo;
    private int sueldo;
    private String cargo;

    public Empleado(){
    }
    public Empleado(int ide, String empleado, String contrasenia, int telefono, String direccion, String sexo, int sueldo, String cargo){
        this.ide=ide;
        this.empleado=empleado;
        this.contrasenia=contrasenia;
        this.telefono=telefono;
        this.direccion=direccion;
        this.sexo=sexo;
        this.sueldo=sueldo;
        this.cargo=cargo;
    }
    
    public Empleado(String empleado){
        this.empleado=empleado;
    }
    
    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @Override
    public String toString(){
        return empleado;
    }
    public int toInt(){
        return ide;
    }
    
    public int agregarVeterinario(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("INSERT INTO empleado (empleado, contrasenia, telefono, direccion, sexo, sueldo, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)");
            instruccion.setString(1, empleado);  //direccion, String , int  String cargo
            instruccion.setString(2, contrasenia);
            instruccion.setInt(3, telefono);
            instruccion.setString(4, direccion);
            instruccion.setString(5, sexo);
            instruccion.setInt(6, sueldo);
            instruccion.setString(7, cargo);
            instruccion.executeUpdate();
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int editarVeterinario(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("UPDATE empleado SET empleado = ?, contrasenia = ?, telefono = ?, direccion = ?, sexo = ? , sueldo = ?, cargo = ? WHERE idempleado = ?");
            instruccion.setString(1, empleado);
            instruccion.setString(2, contrasenia);
            instruccion.setInt(3, telefono);
            instruccion.setString(4, direccion);
            instruccion.setString(5, sexo);
            instruccion.setInt(6, sueldo);
            instruccion.setString(7, cargo);
            instruccion.setInt(8, ide);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int eliminarVeterinario(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("DELETE FROM empleado WHERE idempleado = ?");
            instruccion.setInt(1, ide);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public static void almacenarInfoE(Connection conn, ObservableList<Empleado> lista){
            try{
                Statement sta = conn.createStatement();
                ResultSet resultado = sta.executeQuery("Select idempleado, empleado, contrasenia, telefono, direccion, sexo, sueldo, cargo from empleado");
                while(resultado.next()){
                    lista.add(new Empleado(resultado.getInt("idempleado"), resultado.getString("empleado"), resultado.getString("contrasenia"), resultado.getInt("telefono"), resultado.getString("direccion"), resultado.getString("sexo"), resultado.getInt("sueldo"), resultado.getString("cargo"))); 
                }
            }catch(SQLException e){ 
                e.printStackTrace();
            }
    }
    public static void almacenarE(Connection conn, ObservableList<Empleado> lista){
            try{
                Statement sta = conn.createStatement();
                ResultSet resultado = sta.executeQuery("Select empleado from empleado");
                while(resultado.next()){
                    lista.add(new Empleado(resultado.getString("empleado"))); 
                }
            }catch(SQLException e){ 
                e.printStackTrace();
            }
    }
    
    
    /*public String InicioDeSesion(Connection conn, String Usuario)throws SQLException{
        try{
            PreparedStatement consultar = conn.prepareStatement("SELECT Usuario FROM usuarios WHERE Usuario= '"+Usuario+"'");
            ResultSet consultaUser= consultar.executeQuery();
            String user=null;
            while(consultaUser.next()){
                user=consultaUser.getString(1);
            }
            if (user==null){
                return "nope.";
            }
            else{
                try{
                    consultar = conn.prepareStatement("SELECT Contraseña FROM usuarios WHERE Usuario= '"+Usuario+"'");
                    ResultSet contraseñaconsulta= consultar.executeQuery();
                    String password=null;
                    while(contraseñaconsulta.next()){
                        password=contraseñaconsulta.getString(1);
                    }
                    return password;
                }catch(SQLException ex){
                   return "nope.";
                }
            }
        }catch(SQLException ex){
            return "nope.";
        }  
        
    }*/
    
}
