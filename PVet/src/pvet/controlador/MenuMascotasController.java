package pvet.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pvet.modelo.Articulo;
import pvet.modelo.Conexion;
import pvet.modelo.Mascota;
import pvet.vista.Ventanas;

public class MenuMascotasController implements Initializable {

    Ventanas v  = new Ventanas();
    private Conexion conexion;
    @FXML
    private JFXButton btni, btnm, btnv, btnc, btna, btnven;
    @FXML
    private JFXTextField txtm, txtd, txtt, txtdir, txtr, txtid;
    @FXML
    private JFXButton btnagregar, btneditar, btneliminar, btnlimpiar;
    @FXML
    private ObservableList<Mascota> listamascotas;
    @FXML
    private TableView <Mascota> mascotatabla;
    @FXML
    private TableColumn <Mascota, String> cmascota;
    @FXML
    private TableColumn <Mascota, String> cduenio;
    @FXML
    private TableColumn <Mascota, Integer> ctel;
    @FXML
    private TableColumn <Mascota, String> cdireccion;
    @FXML
    private TableColumn <Mascota, String> craza;
    @FXML
    private TableColumn <Mascota, Integer> cid;
    
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
        conexion = new Conexion();
        conexion.vConexion();
        listamascotas = FXCollections.observableArrayList();
        Mascota.agregarInformacionM(conexion.getConnection(), listamascotas);
        mascotatabla.setItems(listamascotas);
        cmascota.setCellValueFactory(new PropertyValueFactory<Mascota, String>("mascota"));
        cduenio.setCellValueFactory(new PropertyValueFactory<Mascota, String>("duenio"));
        ctel.setCellValueFactory(new PropertyValueFactory<Mascota, Integer>("tel"));
        cdireccion.setCellValueFactory(new PropertyValueFactory<Mascota, String>("direccion"));
        craza.setCellValueFactory(new PropertyValueFactory<Mascota, String>("raza"));
        cid.setCellValueFactory(new PropertyValueFactory<Mascota, Integer>("id"));
        gestionarEventos();
        conexion.cConnection();
    }    
    public void gestionarEventos(){
        mascotatabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Mascota>(){
            @Override
            public void changed(ObservableValue<? extends Mascota> observable, Mascota valorAnterior, Mascota valorSeleccionado) {
                if (valorSeleccionado != null){
                    txtm.setText(valorSeleccionado.getMascota());
                    txtd.setText(valorSeleccionado.getDuenio());
                    txtt.setText(String.valueOf(valorSeleccionado.getTel()));
                    txtdir.setText(valorSeleccionado.getDireccion());
                    txtr.setText(valorSeleccionado.getRaza());
                    txtid.setText(String.valueOf(valorSeleccionado.getId()));
                    
                    btnagregar.setDisable(true);
                    btneditar.setDisable(false);
                    btneliminar.setDisable(false);
                }
            }
         
        });
    }
    
    @FXML
    public void guardar() throws SQLException{
        Mascota m;
        m = new Mascota(txtm.getText(), txtd.getText(), Integer.valueOf(txtt.getText()), txtdir.getText(), txtr.getText());
        conexion.vConexion();
        int resultado = m.agregarMascota(conexion.getConnection());
        conexion.cConnection(); 
        if (resultado == 1){
            listamascotas.add(m);
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se agrego correctamente...");
            mensaje.setContentText("La información de la mascota fue registrada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    
    @FXML
    public void editar() throws SQLException{
        Mascota m;
        m = new Mascota(Integer.valueOf(txtid.getText()), txtm.getText(), txtd.getText(), Integer.valueOf(txtt.getText()), txtdir.getText(), txtr.getText());
        conexion.vConexion(); 
        int resultado = m.editarMascota(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listamascotas.set(mascotatabla.getSelectionModel().getSelectedIndex(), m);
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se edito correctamente...");
            mensaje.setContentText("La información de la mascota fue actualizada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    
    
    @FXML
    public void eliminar() throws SQLException{
        conexion.vConexion();
        Alert mensaje = new Alert(AlertType.WARNING,"", ButtonType.OK, ButtonType.CANCEL);
        mensaje.setTitle("Advertencia...");
        mensaje.setContentText("¿Está seguro de querer eliminar la mascota con su información?");
        mensaje.setHeaderText("Eliminación de Mascota");
        Optional<ButtonType> respuesta = mensaje.showAndWait();
        if(respuesta.get() == ButtonType.OK){
            mascotatabla.getSelectionModel().getSelectedItem().eliminarMascota(conexion.getConnection());
            listamascotas.remove(mascotatabla.getSelectionModel().getSelectedIndex());
        }
        conexion.cConnection();
    }
    
    @FXML
    public void limpiarComponentes(){
        txtm.setText(null);
        txtd.setText(null);
        txtt.setText(null);
        txtdir.setText(null);
        txtr.setText(null);
        txtid.setText(null);
        btnagregar.setDisable(false);
        btneditar.setDisable(true);
        btneliminar.setDisable(true);
    }
}
