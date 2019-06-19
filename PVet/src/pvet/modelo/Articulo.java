package pvet.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Articulo {
    private int ida;
    private StringProperty artic;
    private IntegerProperty cantidad;
    private StringProperty tipomascota;
    private StringProperty descripcion;
    private IntegerProperty precio;

    public Articulo(){
    }
    public Articulo(int ida, String artic, Integer cantidad, String tipomascota, String descripcion, Integer precio){
       this.ida=ida;
       this.artic= new SimpleStringProperty(artic);
       this.cantidad= new SimpleIntegerProperty(cantidad);
       this.tipomascota= new SimpleStringProperty(tipomascota);
       this.descripcion= new SimpleStringProperty(descripcion);
       this.precio= new SimpleIntegerProperty(precio);
    }
    
    public Articulo(String artic){
       this.artic= new SimpleStringProperty(artic);
    }
    public Articulo(int ida){
        this.ida=ida;
    }
    
    public int getIda() {
        return ida;
    }

    public void setIda(Integer ida) {
        this.ida = ida;
    }

    public String getArtic() {
        return artic.get();
    }

    public void setArtic(String artic) {
        this.artic = new SimpleStringProperty(artic);
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }

    public String getTipomascota() {
        return tipomascota.get();
    }

    public void setTipomascota(String tipomascota) {
        this.tipomascota = new SimpleStringProperty(tipomascota);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public int getPrecio() {
        return precio.get();
    }

    public void setPrecio(Integer precio) {
        this.precio = new SimpleIntegerProperty(precio);
    }

    public int agregarArticulo(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("INSERT INTO articulo (arti, cantidad, tipomascota, descripcion, precio) VALUES (?, ?, ?, ?, ?)");
            instruccion.setString(1, artic.get());
            instruccion.setInt(2, cantidad.get());
            instruccion.setString(3, tipomascota.get());
            instruccion.setString(4, descripcion.get());
            instruccion.setInt(5, precio.get());
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
      
    public static void almacenarInfoA(Connection con, ObservableList<Articulo> lista){
            try{
                Statement sta = con.createStatement();
                ResultSet resultado = sta.executeQuery("select idarticulo, arti, cantidad, tipomascota, descripcion, precio from articulo;");
                while(resultado.next()){
                    lista.add(new Articulo(resultado.getInt("idarticulo"), resultado.getString("arti"), resultado.getInt("cantidad"), resultado.getString("tipomascota"), resultado.getString("descripcion"), resultado.getInt("precio"))); 
                    //System.out.println(lista);
                }
                //System.out.println(resultado);
            }catch(SQLException e){ 
                e.printStackTrace();
            }
    }
    public static void almacenarA(Connection con, ObservableList<Articulo> lista){
            try{
                Statement sta = con.createStatement();
                ResultSet resultado = sta.executeQuery("select arti from articulo;");
                while(resultado.next()){
                    lista.add(new Articulo(resultado.getString("arti"))); 
                }
            }catch(SQLException e){ 
                e.printStackTrace();
            }
    }
    
    public int editarArticulo(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("UPDATE articulo SET arti = ?, cantidad = ?, tipomascota = ?, descripcion = ?, precio = ? WHERE idarticulo = ?");
            instruccion.setString(1, artic.get());
            instruccion.setInt(2, cantidad.get());
            instruccion.setString(3, tipomascota.get());
            instruccion.setString(4, descripcion.get());
            instruccion.setInt(5, precio.get());
            instruccion.setInt(6, ida);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    
    public int eliminarArticulo(Connection conn){
        try{
            PreparedStatement instruccion = conn.prepareStatement("DELETE FROM articulo WHERE idarticulo = ?");
            instruccion.setInt(1, ida);
            return instruccion.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public String toString(){
        return artic.get();
    }
}
