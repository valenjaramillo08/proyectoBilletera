package co.edu.uniquindio.proyectobilletera.proyectobilletera.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.controller.CuentaController;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Administrador;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Cuenta;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.TipoCuenta;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.utils.BilleteraConstantes;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class CuentaViewController {

    CuentaController cuentaController;
    private Cuenta cuentaSeleccionado;
    private ObservableList<Cuenta> listaCuentas = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Cuenta, String> columIdCuenta;

    @FXML
    private TableColumn<Cuenta, String> columNCuenta;

    @FXML
    private Button btAgregar;

    @FXML
    private Label lbNumeroCuenta;

    @FXML
    private Button btActualizar;

    @FXML
    private ComboBox<TipoCuenta> cbTipoCuenta;

    @FXML
    private Label lbBanco;

    @FXML
    private Button btDetalles;

    @FXML
    private TextField tfIdCuenta;

    @FXML
    private Label lbIdCuenta;

    @FXML
    private TableView<Cuenta> tabCuenta;

    @FXML
    private TextField tfBanco;

    @FXML
    private TableColumn<Cuenta, String> columBanco;

    @FXML
    private TextField tfNumeroCuenta;

    @FXML
    private TableColumn<Cuenta, String> ColumTpoCuenta;

    @FXML
    private Button btEliminar;

    @FXML
private void mostrarDetallesCuenta() {
    Cuenta cuentaSeleccionada = tabCuenta.getSelectionModel().getSelectedItem();

    if (cuentaSeleccionada != null) {
        Stage ventanaDetalles = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));

        Label id = new Label("ID Cuenta: " + cuentaSeleccionada.getIdCuenta());
        Label banco = new Label("Banco: " + cuentaSeleccionada.getNombreBanco());
        Label numero = new Label("Número: " + cuentaSeleccionada.getNumeroCuenta());
        Label tipo = new Label("Tipo: " + cuentaSeleccionada.getTipoCuenta());

        layout.getChildren().addAll(id, banco, numero, tipo);

        Scene escena = new Scene(layout, 300, 200);
        ventanaDetalles.setTitle("Detalles de la Cuenta");
        ventanaDetalles.setScene(escena);
        ventanaDetalles.initModality(Modality.APPLICATION_MODAL); // bloquea ventana anterior
        ventanaDetalles.showAndWait();
    } else {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText("Selecciona una cuenta de la tabla primero.");
        alerta.showAndWait();
    }
}


    @FXML
    void eliminarCuenta(ActionEvent event) {
         eliminarCuenta();
    }

    private void eliminarCuenta() {

        if (cuentaSeleccionado != null) {
            boolean eliminado = cuentaController.eliminarCuenta(cuentaSeleccionado.getIdCuenta(),cuentaSeleccionado.getNombreBanco(),cuentaSeleccionado.getNumeroCuenta(),cuentaSeleccionado.getTipoCuenta());

            if (eliminado) {
                listaCuentas.remove(cuentaSeleccionado);
                tabCuenta.refresh(); // Refresca la tabla
                mostrarMensaje("Éxito", "Cuenta eliminada", "La cuenta fue eliminada correctamente", Alert.AlertType.INFORMATION);
                limpiarCampos(); // Limpia los campos
            } else {
                mostrarMensaje("Error", "No se pudo eliminar", "Hubo un problema eliminando la cuenta", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Selección requerida", "No se seleccionó ningúna cuenta", "Por favor selecciona una cuenta de la tabla", Alert.AlertType.WARNING);
        }
    }


    @FXML
    void agregarCuenta(ActionEvent event) {
        agregarCuenta();
    }

    private void agregarCuenta() {
        Cuenta cuenta = crearCuenta();

        if(datosValidos(cuenta)){
            if(cuentaController.agregarCuenta(cuenta.getIdCuenta(),cuenta.getNombreBanco(),cuenta.getNumeroCuenta(),cuenta.getTipoCuenta())){

                listaCuentas.add(cuenta);
                mostrarMensaje(BilleteraConstantes.TITULO_CUENTA_AGREGADO,BilleteraConstantes.HEADER,BilleteraConstantes.BODY_CUENTA_AGREGADO, Alert.AlertType.INFORMATION);
            }

        }else {
            mostrarMensaje(BilleteraConstantes.TITULO_INCOMPLETO,BilleteraConstantes.HEADER,BilleteraConstantes.BODY_INCOMPLETO, Alert.AlertType.WARNING);

        }
    }

    @FXML
    void actualizarCuenta(ActionEvent event) {
        actualizarCuenta();
    }

     public void actualizarCuenta() {

      if (cuentaSeleccionado != null) {
             Cuenta cuentaActualizado = crearCuenta();

             if (datosValidos(cuentaActualizado)) {
                 boolean actualizado = cuentaController.actualizarCuenta(cuentaSeleccionado.getIdCuenta(),cuentaSeleccionado.getIdCuenta(),cuentaSeleccionado.getNombreBanco(),cuentaSeleccionado.getNumeroCuenta(),cuentaSeleccionado.getTipoCuenta());

                 if (actualizado) {
                     int index = listaCuentas.indexOf(cuentaSeleccionado);
                     listaCuentas.set(index, cuentaActualizado);
                     tabCuenta.refresh(); // Refresca la tabla con los nuevos datos
                     mostrarMensaje("Éxito", "Cuenta actualizada", "La cuenta fue actualizado correctamente", Alert.AlertType.CONFIRMATION);
                     limpiarCampos(); // 🔥 Limpia los campos después de actualizar
                 } else {
                     mostrarMensaje("Error", "No se pudo actualizar", "Hubo un problema actualizando la cuenta", Alert.AlertType.ERROR);
                 }
             } else {
                 mostrarMensaje("Datos incompletos", "Verifica los campos", "Todos los campos son obligatorios", Alert.AlertType.WARNING);
             }
         } else {
             mostrarMensaje("Selección requerida", "No se seleccionó ningúna cuenta", "Por favor selecciona una cuenta de la tabla", Alert.AlertType.WARNING);
         }
    }

    

    private Cuenta crearCuenta() {

        return  new Cuenta(
                tfIdCuenta.getText(),
                tfBanco.getText(),
                tfNumeroCuenta.getText(),
                cbTipoCuenta.getSelectionModel().getSelectedItem()
        );
    }

    private boolean datosValidos(Cuenta cuenta) {
        return cuenta != null &&
               cuenta.getIdCuenta() != null && !cuenta.getIdCuenta().isEmpty() &&
               cuenta.getNombreBanco() != null && !cuenta.getNombreBanco().isEmpty() &&
               cuenta.getNumeroCuenta() != null && !cuenta.getNumeroCuenta().isEmpty() &&
               cuenta.getTipoCuenta() != null;
    }

   

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


    private void limpiarCampos() {
        tfIdCuenta.clear();
        tfBanco.clear();
        tfNumeroCuenta.clear();
        cuentaSeleccionado = null;
        tabCuenta.getSelectionModel().clearSelection();
    }

    @FXML
    void initialize() {
    cbTipoCuenta.getItems().addAll(TipoCuenta.values());
    cuentaController = new CuentaController();
       initView();

    }
    private void initView() {
        initDataBinding();
        obtenerCuentas();
        tabCuenta.getItems().clear();
        tabCuenta.setItems(listaCuentas);
        listenerSelection();
    }

    private void initDataBinding() {
        columIdCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCuenta()));
        columNCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroCuenta()));
        columBanco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreBanco()));
        ColumTpoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoCuenta().name()));  
    }

    private void obtenerCuentas() {
        listaCuentas.addAll(cuentaController.obtenerCuentas());
    }

    private void listenerSelection() {
        tabCuenta.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            cuentaSeleccionado = newSelection;
            mostrarInformacionCuenta(cuentaSeleccionado);
        }
        
        );
    }



    private void mostrarInformacionCuenta(Cuenta cuentaSeleccionado) {
        if(cuentaSeleccionado != null){
            tfIdCuenta.setText(cuentaSeleccionado.getIdCuenta());
            tfBanco.setText(cuentaSeleccionado.getNombreBanco());
            tfNumeroCuenta.setText(cuentaSeleccionado.getNumeroCuenta());
        }
    }

}