package pvet.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;
    private String url = "jdbc:mysql://localhost/proyectouv?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "mysql";
    public Connection getConnection(){
        return con;
    }
    public void setConnection(Connection conn){
        this.con=con; 
    }
    public void vConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }    
    public void cConnection(){
        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
