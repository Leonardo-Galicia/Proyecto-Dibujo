/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvet.vista;

import java.awt.Component;
//import java.util.Optional;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Ventanas {
    
    public static Stage stg = new Stage();
    
    public void startLogin() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stg.setTitle("Login...");
        stg.setScene(scene); 
        stg.setHeight(570);
        stg.setWidth(468);
        stg.show();
        stg.setResizable(false);
    }
    
    public void startMenuInicio() throws Exception {
        stg.close();
        Parent root = FXMLLoader.load(getClass().getResource("MenuInicio.fxml"));
        Scene scene = new Scene(root);
        stg.setTitle("Menu Inicio...");
        stg.setScene(scene); 
        stg.setHeight(840);
        stg.setWidth(1226);
        stg.show();
        stg.setResizable(false);
    }
    
    public void startMenuMascotas() throws Exception {
        stg.close();
        Parent root = FXMLLoader.load(getClass().getResource("MenuMascotas.fxml"));
        Scene scene = new Scene(root);
        stg.setTitle("Menu Mascotas...");
        stg.setScene(scene); 
        stg.setHeight(840);
        stg.setWidth(1226);
        stg.show();
        stg.setResizable(false);
    }
    
    public void startMenuVeterinarios() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Veterinarios.fxml"));
        Scene scene = new Scene(root);
        stg.setTitle("Veterinarios...");
        stg.setScene(scene);  
        stg.setHeight(840);
        stg.setWidth(1226);
        stg.show();
        stg.setResizable(false);
    }
    
    public void startMenuArticulos() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Articulos.fxml"));
        Scene scene = new Scene(root);
        stg.setTitle("Articulos...");
        stg.setScene(scene);  
        stg.setHeight(840);
        stg.setWidth(1226);
        stg.show();
        stg.setResizable(false);
    }
    
     public void startMenuVentas() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Ventas.fxml"));
        Scene scene = new Scene(root);
        stg.setTitle("Ventas...");
        stg.setScene(scene);  
        stg.setHeight(840);
        stg.setWidth(1226);
        stg.show();
        stg.setResizable(false);
    }
     
     public void startMenuCitas() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Citas.fxml"));
        Scene scene = new Scene(root);
        stg.setTitle("Citas...");
        stg.setScene(scene);  
        stg.setHeight(840);
        stg.setWidth(1226);
        stg.show();
        stg.setResizable(false);
    }
   
}
