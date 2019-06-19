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
import java.time.LocalDate;
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
import pvet.modelo.Cita;
import pvet.modelo.Conexion;
import pvet.modelo.Empleado;
import pvet.modelo.Mascota;
import pvet.vista.Ventanas;

public class CitasController implements Initializable {

    Ventanas v  = new Ventanas();
    @FXML private JFXButton btni, btnm, btnv, btnc, btna, btnven;
    @FXML private JFXTextField txtcita, txtpago, txtid; 
    //@FXML private JFXComboBox txtdatom, txtdatoe;
    @FXML private DatePicker txtfecha;
    @FXML private JFXButton btnagregar, btneditar, btneliminar, btnlimpiar;
    @FXML private TableView <Cita> citastabla;
    @FXML private TableColumn<Cita, Mascota> cdatosm; 
    @FXML private TableColumn<Cita, Empleado> cdatose;
    @FXML private TableColumn<Cita, String> ctipocita;
    @FXML private TableColumn<Cita, Date> cfecha;
    @FXML private TableColumn<Cita, Integer> cpago;
    @FXML private TableColumn<Cita, Integer> cid;
    @FXML private ComboBox <Mascota> txtdatom;
    @FXML private ComboBox <Empleado> txtdatoe;
    private ObservableList <Cita> listacitas;    
    private ObservableList <Mascota> listamascotas;
    private ObservableList <Empleado> listaempleados;
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
        listacitas = FXCollections.observableArrayList();
        listamascotas = FXCollections.observableArrayList();
        listaempleados = FXCollections.observableArrayList();
       
        Mascota.agregarM(conexion.getConnection(), listamascotas);
        Empleado.almacenarE(conexion.getConnection(), listaempleados);
        Cita.almacenarInfoC(conexion.getConnection(), listacitas);
        
        txtdatom.setItems(listamascotas);
        txtdatoe.setItems(listaempleados);
        citastabla.setItems(listacitas);
        
        cdatosm.setCellValueFactory(new PropertyValueFactory<Cita, Mascota>("a"));
        cdatose.setCellValueFactory(new PropertyValueFactory<Cita, Empleado>("e"));
        ctipocita.setCellValueFactory(new PropertyValueFactory<Cita, String>("tipocita"));
        cfecha.setCellValueFactory(new PropertyValueFactory<Cita, Date>("fecha"));
        cpago.setCellValueFactory(new PropertyValueFactory<Cita, Integer>("pago"));
        cid.setCellValueFactory(new PropertyValueFactory<Cita, Integer>("idcita"));
        gestionarEventos();
        conexion.cConnection();
    }    
    public void gestionarEventos(){
        citastabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cita>(){
            @Override
            public void changed(ObservableValue<? extends Cita> observable, Cita valorAnterior, Cita valorSeleccionado) {
                if (valorSeleccionado != null){
                     //txtdatom, txtdatoe, txtcita, txtfecha, txtpago, txtid
                    txtdatom.setValue(valorSeleccionado.getA());
                    txtdatoe.setValue(valorSeleccionado.getE());
                    txtcita.setText(valorSeleccionado.getTipocita());
                    txtfecha.setValue(valorSeleccionado.getFecha().toLocalDate());
                    txtpago.setText(String.valueOf(valorSeleccionado.getPago()));
                    txtid.setText(String.valueOf(valorSeleccionado.getIdcita()));
                
                    btnagregar.setDisable(true);
                    btneditar.setDisable(false);
                    btneliminar.setDisable(false);
                }
            }
        }); 
    }
    @FXML
    public void guardar(){
        Cita c;
        c = new Cita(0, txtdatom.getSelectionModel().getSelectedItem(), txtdatoe.getSelectionModel().getSelectedItem(), txtcita.getText(), Date.valueOf(txtfecha.getValue()), Integer.valueOf(txtpago.getText()));
        conexion.vConexion(); 
        int resultado = c.agregarCita(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listacitas.add(c);
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se agrego correctamente...");
            mensaje.setContentText("La información de la cita fue registrada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    @FXML
    public void editar(){
        Cita c;
        c = new Cita(Integer.valueOf(txtid.getText()), txtdatom.getSelectionModel().getSelectedItem(), txtdatoe.getSelectionModel().getSelectedItem(), txtcita.getText(), Date.valueOf(txtfecha.getValue()), Integer.valueOf(txtpago.getText()));
        conexion.vConexion(); 
        int resultado = c.editarCitas(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listacitas.set(citastabla.getSelectionModel().getSelectedIndex(), c);
            Alert mensaje = new Alert((AlertType.INFORMATION));
            mensaje.setTitle("Se edito correctamente...");
            mensaje.setContentText("La información del artìculo fue actualizada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    @FXML
    public void eliminar(){
        conexion.vConexion();
        int resultado = citastabla.getSelectionModel().getSelectedItem().eliminarCita(conexion.getConnection());
        conexion.cConnection(); 
         
        if (resultado == 1){
            listacitas.remove(citastabla.getSelectionModel().getSelectedIndex());
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se elimino correctamente...");
            mensaje.setContentText("La información del artìculo fue eliminada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    @FXML
    public void limpiarComponentes(){
        //txtdatom, txtdatoe, txtcita, txtfecha, txtpago, txtid
        txtdatom.setValue(null);
        txtdatoe.setValue(null);
        txtfecha.setValue(null);
        txtpago.setText(null);
        txtid.setText(null);
        txtcita.setText(null);
              
        btnagregar.setDisable(true);
        btneditar.setDisable(false);
        btneliminar.setDisable(false);
    }
}
