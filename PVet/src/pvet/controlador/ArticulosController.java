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
import pvet.vista.Ventanas;

/**
 * FXML Controller class
 *
 * @author Leonardo Galicia
 */
public class ArticulosController implements Initializable {

    Ventanas v  = new Ventanas();
    @FXML private JFXButton btni, btnm, btnv, btnc, btna, btnven;
    @FXML private JFXTextField txtar, txtcan, txttipo, txtdes, txtpre, txtid;
    @FXML private JFXButton btnagregar, btneditar, btneliminar, btnlimpiar;
    @FXML private TableView<Articulo> articulotabla;
    @FXML private TableColumn<Articulo, String> carticulo;
    @FXML private TableColumn<Articulo, Integer> ccantidad;
    @FXML private TableColumn<Articulo, String> ctipomas;
    @FXML private TableColumn<Articulo, String> cdescripcion;
    @FXML private TableColumn<Articulo, Integer> cprecio;
    @FXML private TableColumn<Articulo, Integer> cid;
    @FXML private ObservableList<Articulo> listaArticulos;
    private Conexion conexion;
    
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
        //iicializar listas
        listaArticulos = FXCollections.observableArrayList();
        //Llenar listas
        Articulo.almacenarInfoA(conexion.getConnection(), listaArticulos);
        articulotabla.setItems(listaArticulos);
        carticulo.setCellValueFactory(new PropertyValueFactory<Articulo, String>("artic"));
        ccantidad.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("cantidad"));
        ctipomas.setCellValueFactory(new PropertyValueFactory<Articulo, String>("tipomascota"));
        cdescripcion.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
        cprecio.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("precio"));
        cid.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("ida"));
        gestionarEventos();
        conexion.cConnection();
    }    
    
        
    public void gestionarEventos(){
        articulotabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Articulo>(){
            @Override
            public void changed(ObservableValue<? extends Articulo> observable, Articulo valorAnterior, Articulo valorSeleccionado) {
                if (valorSeleccionado != null){
                    txtar.setText(valorSeleccionado.getArtic());
                    txtcan.setText(String.valueOf(valorSeleccionado.getCantidad()));
                    txttipo.setText(valorSeleccionado.getTipomascota());
                    txtdes.setText(valorSeleccionado.getDescripcion());
                    txtpre.setText(String.valueOf(valorSeleccionado.getPrecio()));
                    txtid.setText(String.valueOf(valorSeleccionado.getIda()));
                
                    btnagregar.setDisable(true);
                    btneditar.setDisable(false);
                    btneliminar.setDisable(false);
                }
            }
            
        });
    }
    
    @FXML
    public void guardar(){
        Articulo a;
        a = new Articulo(0, txtar.getText(), Integer.valueOf(txtcan.getText()), txttipo.getText(), txtdes.getText(), Integer.valueOf(txtpre.getText()));
        conexion.vConexion(); 
        int resultado = a.agregarArticulo(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listaArticulos.add(a);
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se agrego correctamente...");
            mensaje.setContentText("La información del artículo fue registrada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    
    @FXML
    public void editar() throws SQLException{
        Articulo a;
        a = new Articulo(Integer.valueOf(txtid.getText()), txtar.getText(), Integer.valueOf(txtcan.getText()), txttipo.getText(), txtdes.getText(), Integer.valueOf(txtpre.getText()));
        conexion.vConexion(); 
        int resultado = a.editarArticulo(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listaArticulos.set(articulotabla.getSelectionModel().getSelectedIndex(), a);
            Alert mensaje = new Alert((AlertType.INFORMATION));
            mensaje.setTitle("Se edito correctamente...");
            mensaje.setContentText("La información del artìculo fue actualizada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    
    @FXML
    public void eliminar() throws SQLException{
        conexion.vConexion();
        Alert mensaje = new Alert(AlertType.WARNING,"", ButtonType.OK, ButtonType.CANCEL);
        mensaje.setTitle("Advertencia...");
        mensaje.setContentText("¿Está seguro de querer eliminar el artículo con su información?");
        mensaje.setHeaderText("Eliminación del Artículo");
        Optional<ButtonType> respuesta = mensaje.showAndWait();
        //mensaje.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        if(respuesta.get() == ButtonType.OK){
            articulotabla.getSelectionModel().getSelectedItem().eliminarArticulo(conexion.getConnection());
            listaArticulos.remove(articulotabla.getSelectionModel().getSelectedIndex());
        }
        conexion.cConnection();
    }
    
    @FXML
    public void limpiarComponentes(){
        txtar.setText(null);
        txtcan.setText(null);
        txttipo.setText(null);
        txtdes.setText(null);
        txtpre.setText(null);
        txtid.setText(null);
        
        btnagregar.setDisable(false);
        btneditar.setDisable(true);
        btneliminar.setDisable(true);
    }
    
}
