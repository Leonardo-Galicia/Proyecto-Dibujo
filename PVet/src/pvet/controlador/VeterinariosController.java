package pvet.controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import pvet.modelo.Empleado;
import pvet.vista.Ventanas;


public class VeterinariosController implements Initializable {

    Ventanas v  = new Ventanas();
    @FXML
    private JFXButton btni, btnm, btnv, btnc, btna, btnven;
    
    @FXML
    private JFXTextField txtn, txtc, txttel, txtdir, txtse, txtsuel, txtcargo, txtid;
    
    @FXML
    private JFXButton btnagregar, btneditar, btneliminar, btnlimpiar;
    
    @FXML private TableView<Empleado> veterinariotabla;
    @FXML private TableColumn<Empleado, String> cempleado;
    @FXML private TableColumn<Empleado, String> ccontrasenia;
    @FXML private TableColumn<Empleado, Integer> ctelefono;
    @FXML private TableColumn<Empleado, String> cdireccione;
    @FXML private TableColumn<Empleado, String> cse;
    @FXML private TableColumn<Empleado, Integer> csueldo;
    @FXML private TableColumn<Empleado, String> ccargo;
    @FXML private TableColumn<Empleado, Integer> cidv;
    @FXML
    private ObservableList <Empleado> listaveterinario;
    
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
        //inicializar listas
        listaveterinario = FXCollections.observableArrayList();
        //Llenar listas
        Empleado.almacenarInfoE(conexion.getConnection(), listaveterinario);
        veterinariotabla.setItems(listaveterinario);
        cempleado.setCellValueFactory(new PropertyValueFactory<Empleado, String>("empleado"));
        ccontrasenia.setCellValueFactory(new PropertyValueFactory<Empleado, String>("contrasenia"));
        ctelefono.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("telefono"));
        cdireccione.setCellValueFactory(new PropertyValueFactory<Empleado, String>("direccion"));
        cse.setCellValueFactory(new PropertyValueFactory<Empleado, String>("sexo"));
        csueldo.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("sueldo"));
        ccargo.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cargo"));
        cidv.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("ide"));
        gestionarEventos();
        conexion.cConnection();
    }    
    public void gestionarEventos(){
        veterinariotabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Empleado>(){
            @Override
            /*txtn, txtc, txttel, txtdir, txtse, txtsuel, txtcargo;*/
            
            public void changed(ObservableValue<? extends Empleado> observable, Empleado valorAnterior, Empleado valorSeleccionado) {
                if (valorSeleccionado != null){    
                    txtn.setText(valorSeleccionado.getEmpleado());
                    txtc.setText(valorSeleccionado.getContrasenia());
                    txttel.setText(String.valueOf(valorSeleccionado.getTelefono()));
                    txtdir.setText(valorSeleccionado.getDireccion());
                    txtse.setText(valorSeleccionado.getSexo());
                    txtsuel.setText(String.valueOf(valorSeleccionado.getSueldo()));
                    txtcargo.setText(valorSeleccionado.getCargo());
                    txtid.setText(String.valueOf(valorSeleccionado.getIde()));
                                
                    btnagregar.setDisable(true);
                    btneditar.setDisable(false);
                    btneliminar.setDisable(false);
                }
            }
            
        });
    }
    @FXML
    public void guardar(){
        Empleado e;//
        e = new Empleado(Integer.valueOf(txtid.getText()), txtn.getText(), txtc.getText(), Integer.valueOf(txttel.getText()), txtdir.getText(), txtse.getText(), Integer.valueOf(txtsuel.getText()), txtcargo.getText());
        conexion.vConexion(); 
        int resultado = e.agregarVeterinario(conexion.getConnection());
        conexion.cConnection();
        if (resultado == 1){
            listaveterinario.add(e);
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se agrego correctamente...");
            mensaje.setContentText("La información del veterinario fue registrada correctamente");
            mensaje.setHeaderText("Resultado: ");
            mensaje.show();
        }
    }
    
    @FXML
    public void editar() throws SQLException{
        Empleado e;
        e = new Empleado(Integer.valueOf(txtid.getText()), txtn.getText(), txtc.getText(), Integer.valueOf(txttel.getText()), txtdir.getText(), txtse.getText(), Integer.valueOf(txtsuel.getText()), txtcargo.getText());
        conexion.vConexion(); 
        int resultado = e.editarVeterinario(conexion.getConnection());
        conexion.cConnection(); 
        if (resultado == 1){
            listaveterinario.set(veterinariotabla.getSelectionModel().getSelectedIndex(), e);
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Se edito correctamente...");
            mensaje.setContentText("La información del veterinario fue actualizada correctamente");
            mensaje.setHeaderText("Resultado: "+ e.getEmpleado());
            mensaje.show();
        }
    }
    
    @FXML
    public void eliminar() throws SQLException{
        conexion.vConexion();
        Alert mensaje = new Alert(AlertType.WARNING,"", ButtonType.OK, ButtonType.CANCEL);
        mensaje.setTitle("Advertencia...");
        mensaje.setContentText("¿Está seguro de querer eliminar al empleado?");
        mensaje.setHeaderText("Eliminación de Veterinario");
        Optional<ButtonType> respuesta = mensaje.showAndWait();
        if(respuesta.get() == ButtonType.OK){
            veterinariotabla.getSelectionModel().getSelectedItem().eliminarVeterinario(conexion.getConnection());
            listaveterinario.remove(veterinariotabla.getSelectionModel().getSelectedIndex());
        }
        conexion.cConnection(); 
    }
    
    @FXML
    public void limpiarComponentes(){
        txtn.setText(null);
        txtc.setText(null);
        txttel.setText(null);
        txtdir.setText(null);
        txtse.setText(null);
        txtsuel.setText(null);
        txtcargo.setText(null);
        txtid.setText(null);
        
        btnagregar.setDisable(true);
        btneditar.setDisable(false);
        btneliminar.setDisable(false);
    }
    
    private boolean validarDatos(){
        boolean valido = true;
        String nombre = txtn.getText();
        String pass = txtc.getText();
        String tel = txttel.getText();
        String dire = txtdir.getText();
        String s = txtse.getText();
        String su = txtsuel.getText();
        String ca = txtcargo.getText();
        String errores = "";
        if (nombre.trim().length() == 0)
            errores += "* El nombre del empleado no debe estar vacío\n";
        if (pass.trim().length() == 0)
            errores += "* La contraseña del empleado no debe estar vacía\n";
        if (tel.trim().length() == 0)
            errores += "* El telefono del empleado no debe estar vacío\n";
        if (dire.trim().length() == 0)
            errores += "* La dirección del empleado no debe estar vacío\n";
        if (s.trim().length() == 0)
            errores += "* El sexo del empleado no debe estar vacío\n";
        if (su.trim().length() == 0)
            errores += "* El sueldo del empleado no debe estar vacío\n";
        if (ca.trim().length() == 0)
            errores += "* El cargo del empleado no debe estar vacío\n";
        if(errores.length() > 0){
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setTitle("Error");
            dialogo.setHeaderText("Datos faltantes");
            dialogo.setContentText(errores);
            dialogo.show();
            valido = false;
        }
        return valido;
    }
}
