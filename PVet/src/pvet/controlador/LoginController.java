/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvet.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import pvet.vista.Ventanas;

public class LoginController implements Initializable {
    Ventanas v = new Ventanas ();
    @FXML
    private Image imagen;
    @FXML
    private JFXTextField usuario;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXButton btnIngresar;
     
        
    @FXML
    private void Inicio(ActionEvent event) throws Exception {
        if(usuario.getText().equals("Admin") && pass.getText().equals("123")){
            v.startMenuInicio();
        }else{
            Alert fallo = new Alert(AlertType.WARNING);
            fallo.setTitle("FALLO AL INICIAR SESIÒN");
            fallo.setHeaderText("Hay un problema al iniciar sesiòn");
            fallo.setContentText("Tu usuario o contraseña tienen un error, o esta vacio un campo o estan mal escritos, verifica bien los datos que ingresaste");
            fallo.initStyle(StageStyle.UTILITY);
            fallo.showAndWait();
        }    
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
