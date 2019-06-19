package pvet.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pvet.vista.Ventanas;


public class MenuInicioController implements Initializable {

    Ventanas v  = new Ventanas();
    @FXML
    private JFXButton btni, btnm, btnv, btnc, btna, btnven;
    @FXML
    private JFXTextField txta, txtc, txttipo, txtd, txtp;
    @FXML
    private JFXButton btnagregar, btneditar, btneliminar;
    @FXML
    private void Ini(ActionEvent event) throws Exception {
        v.startMenuInicio();
    }
    @FXML
    private void Mas(ActionEvent event) throws Exception {
        v.startMenuMascotas();
    }
    @FXML
    private void Vet(ActionEvent event) throws Exception {
        v.startMenuVeterinarios();
    }
    @FXML
    private void Cit(ActionEvent event) throws Exception {
        v.startMenuCitas();
    }
    @FXML
    private void Art(ActionEvent event) throws Exception {
        v.startMenuArticulos();
    }
    @FXML
    private void Ven(ActionEvent event) throws Exception {
        v.startMenuVentas();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
