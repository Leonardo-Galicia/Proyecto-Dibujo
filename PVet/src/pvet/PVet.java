/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pvet.vista.Ventanas;

/**
 *
 * @author Leonardo
 */
public class PVet extends Application {
    
    private Ventanas ventana = new Ventanas();
    //Metodos
    @Override
    public void start(Stage stage) throws Exception {
        ventana.startLogin();
    }

    /*public static void main(String[] args) {
        launch(args);
    }*/
    
}
