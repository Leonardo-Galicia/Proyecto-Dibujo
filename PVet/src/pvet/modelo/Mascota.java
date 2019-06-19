package pvet.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

public class Mascota {
    private int id;
    private String mascota;
    private String duenio;
    private int tel;
    private String direccion;
    private String raza;

    public Mascota(){
    }
    
    public Mascota(int id, String mascota, String  duenio, int tel, String direccion, String raza){
        this.id=id;
        this.mascota=mascota;
        this.duenio=duenio;
        this.tel=tel;
        this.direccion=direccion;
        this.raza=raza;
    }   
    public Mascota(String mascota, String  duenio, int tel, String direccion, String raza){
        this.mascota=mascota;
        this.duenio=duenio;
        this.tel=tel;
        this.direccion=direccion;
        this.raza=raza;
    }   
    public Mascota(String mascota){
        this.mascota=mascota;
    }  
    public Mascota(int id){
        this.id=id;
    } 
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMascota() {
        return mascota;
    }
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
    public String getDuenio() {
        return duenio;
    }
    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }
    public int getTel() {
        return tel;
    }
    public void setTel(int tel) {
        this.tel = tel;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    @Override
    public String toString(){
        return mascota;
    }
    public int toInt(){
        return id;
    }
    
    public int agregarMascota(Connection conn) throws SQLException{
        try{
            PreparedStatement instruccion = conn.prepareStatement("INSERT INTO mascota (nMascota, duenio, telefono, direccion, raza) VALUES (?, ?, ?, ?, ?)");
            instruccion.setString(1, mascota);
            instruccion.setString(2, duenio);
            instruccion.setInt(3, tel);
            instruccion.setString(4, direccion);
            instruccion.setString(5, raza);
            //instruccion.executeUpdate();
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
        
    }
     
    public int editarMascota(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("UPDATE mascota SET nMascota = ?, duenio = ?, telefono = ?, direccion = ?, raza = ? WHERE idMascota = ?");
            instruccion.setString(1, mascota);
            instruccion.setString(2, duenio);
            instruccion.setInt(3, tel);
            instruccion.setString(4, direccion);
            instruccion.setString(5, raza);
            instruccion.setInt(6, id);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int eliminarMascota(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("DELETE FROM mascota WHERE idMascota = ?");
            instruccion.setInt(1, id);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public static void agregarInformacionM(Connection conn, ObservableList<Mascota> lista){
        try{
            Statement sta = conn.createStatement();
            ResultSet resultado = sta.executeQuery("Select idMascota, nMascota, duenio, telefono, direccion, raza from mascota");
            while(resultado.next()){
                lista.add(new Mascota(resultado.getInt("idMascota"), resultado.getString("nMascota"), resultado.getString("duenio"), resultado.getInt("telefono"), resultado.getString("direccion"), resultado.getString("raza"))); 
            }
        }catch(SQLException e){ 
            e.printStackTrace();
        }   
    }
    public static void agregarM(Connection conn, ObservableList<Mascota> lista){
        try{
            Statement sta = conn.createStatement();
            ResultSet resultado = sta.executeQuery("Select nMascota from mascota");
            while(resultado.next()){
                lista.add(new Mascota(resultado.getString("nMascota")) ); 
            }
        }catch(SQLException e){ 
            e.printStackTrace();
        }   
    }
    
}
