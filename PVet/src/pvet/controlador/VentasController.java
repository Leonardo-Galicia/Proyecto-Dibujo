/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvet.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pvet.modelo.Articulo;
import pvet.modelo.Conexion;
import pvet.modelo.Empleado;
import pvet.modelo.Venta;
import pvet.vista.Ventanas;

/**
 * FXML Controller class
 *
 * @author Leonardo Galicia
 */
public class VentasController implements Initializable {

    Ventanas v  = new Ventanas();
    @FXML private JFXButton btni, btnm, btnv, btnc, btna, btnven;
    @FXML private JFXButton btnagregar, btneditar, btneliminar, btnlimpiar;
    @FXML private JFXTextField txtcant, txtid;  
    @FXML private ComboBox <Articulo> txtdatoa;
    @FXML private ComboBox <Empleado> txtdatoe;
    @FXML private DatePicker txtfecha;
    @FXML private TableView <Venta> ventastabla;
    @FXML private TableColumn<Venta, Articulo> cdatosa;
    @FXML private TableColumn<Venta, Empleado> cdatose;
    @FXML private TableColumn<Venta, Date> cfecha;
    @FXML private TableColumn<Venta, Integer> ccant;
    @FXML private TableColumn<Venta, Integer> cid;
    private ObservableList <Articulo> listaarticulos;
    private ObservableList <Empleado> listaempleados;
    private ObservableList <Venta> listaventas;    
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
        listaventas = FXCollections.observableArrayList();
        listaarticulos = FXCollections.observableArrayList();
        listaempleados = FXCollections.observableArrayList();
        
        Articulo.almacenarA(conexion.getConnection(), listaarticulos);
        Empleado.almacenarE(conexion.getConnection(), listaempleados);
        Venta.almacenarInfoV(conexion.getConnection(), listaventas);
        
        txtdatoa.setItems(listaarticulos);
        txtdatoe.setItems(listaempleados);
        ventastabla.setItems(listaventas);
        
        cdatosa.setCellValueFactory(new PropertyValueFactory<Venta, Articulo>("ar"));
        cdatose.setCellValueFactory(new PropertyValueFactory<Venta, Empleado>("em"));
        cfecha.setCellValueFactory(new PropertyValueFactory<Venta, Date>("fechaven"));
        ccant.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("cant"));
        cid.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("idventa"));
        gestionarEventos();
        conexion.cConnection(); 
    }    
    public void gestionarEventos(){
        ventastabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Venta>(){
            @Override
            public void changed(ObservableValue<? extends Venta> observable, Venta valorAnterior, Venta valorSeleccionado) {
                if (valorSeleccionado != null){
                     
                    txtdatoa.setValue(valorSeleccionado.getAr());
                    txtdatoe.setValue(valorSeleccionado.getEm());
                    txtfecha.setValue(valorSeleccionado.getFechaven().toLocalDate());
                    txtcant.setText(String.valueOf(valorSeleccionado.getCant()));
                    txtid.setText(String.valueOf(valorSeleccionado.getIdventa()));
                
                    btnagregar.setDisable(true);
                    btneditar.setDisable(false);
                    btneliminar.setDisable(false);
                }
            }
        }); 
    }
    @FXML
    public void guardar(){
        Venta v;
        v = new Venta(0, txtdatoa.getSelectionModel().getSelectedItem(), txtdatoe.getSelectionModel().getSelectedItem(), Date.valueOf(txtfecha.getValue()), Integer.valueOf(txtcant.getText()));
        conexion.vConexion(); 
        int resultado = v.agregarVentas(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listaventas.add(v);
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se agrego correctamente...");
            mensaje.setContentText("La información de la venta fue registrada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    @FXML
    public void editar(){
        Venta v;
        v = new Venta(Integer.valueOf(txtid.getText()), txtdatoa.getSelectionModel().getSelectedItem(), txtdatoe.getSelectionModel().getSelectedItem(), Date.valueOf(txtfecha.getValue()), Integer.valueOf(txtcant.getText()));
        conexion.vConexion(); 
        int resultado = v.editarVentas(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listaventas.set(ventastabla.getSelectionModel().getSelectedIndex(), v);
            Alert mensaje = new Alert((AlertType.INFORMATION));
            mensaje.setTitle("Se edito correctamente...");
            mensaje.setContentText("La información de la venta fue actualizada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    @FXML
    public void eliminar(){
        conexion.vConexion();
        int resultado = ventastabla.getSelectionModel().getSelectedItem().eliminarVentas(conexion.getConnection());
        conexion.cConnection(); 
         
        if (resultado == 1){
            listaventas.remove(ventastabla.getSelectionModel().getSelectedIndex());
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se elimino correctamente...");
            mensaje.setContentText("La información de la venta fue eliminada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    @FXML
    public void limpiarComponentes(){
        //txtdatoa, txtdatoe, txtfecha, txtcant, txtid
        txtdatoa.setValue(null);
        txtdatoe.setValue(null);
        txtfecha.setValue(null);
        txtcant.setText(null);
        txtid.setText(null);
        
        
        btnagregar.setDisable(true);
        btneditar.setDisable(false);
        btneliminar.setDisable(false);
    }
}
