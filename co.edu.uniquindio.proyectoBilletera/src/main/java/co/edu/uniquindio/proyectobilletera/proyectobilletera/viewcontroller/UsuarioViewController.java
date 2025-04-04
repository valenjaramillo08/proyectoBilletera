package co.edu.uniquindio.proyectobilletera.proyectobilletera.viewcontroller;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.utils.BilleteraConstantes;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.controller.UsuarioController;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UsuarioViewController {
        UsuarioController usuarioController;
        ObservableList<UsuarioDto> listaUsuarios = FXCollections.observableArrayList();
        UsuarioDto usuarioSeleccionado;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableColumn<UsuarioDto,String> columNombre;

        @FXML
        private TableColumn<UsuarioDto, String> columCorreo;

        @FXML
        private TextField txtNombre;

        @FXML
        private TableColumn<UsuarioDto, String> columApellido;

        @FXML
        private TableColumn<UsuarioDto, String> columIdentificacion;

        @FXML
        private Button btnNuevo;

        @FXML
        private TextField txtApellido;

        @FXML

        private TableView<?> tableUsuarios;


        @FXML
        private Button btnAgregar;

        @FXML
        private TextField txtIdentificacion;

        @FXML
        private TextField txtCorreo;

        @FXML
        private Button btnActualizar;

        @FXML
        void onNuevo(ActionEvent event) {

        }

        @FXML
        void onAgregar(ActionEvent event) {
            agregarUsuario();

        }

    private void agregarUsuario() {
        UsuarioDto usuarioDto = crearUsuario();

        if(datosValidos(usuarioDto)){
            if(usuarioController.agregarUsuario(usuarioDto)){
                listaUsuarios.add(usuarioDto);
                mostrarMensaje(BilleteraConstantes.TITULO_USUARIO_NO_AGREGADO,BilleteraConstantes.HEADER,BilleteraConstantes.BODY_USUARIO_NO_AGREGADO, Alert.AlertType.ERROR);
            }

        }else {
            mostrarMensaje(BilleteraConstantes.TITULO_INCOMPLETO,BilleteraConstantes.HEADER,BilleteraConstantes.BODY_INCOMPLETO, Alert.AlertType.WARNING);

        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
            Alert alert = new Alert(alertType);
            alert.setTitle(titulo);
            alert.setHeaderText(header);
            alert.setContentText(contenido);
            alert.showAndWait();
    }


    @FXML
        void onActualizar(ActionEvent event) {

        }

        @FXML
        void initialize() {
            usuarioController = new UsuarioController();
            initView();

        }

    private void initView() {
        initDataBinding();
        obtenerUsuarios();
        tableUsuarios.getItems().clear();
        tableUsuarios.setItems(listaUsuarios);
        listenerSelection();
    }

    private void initDataBinding() {
        columNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        columApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        columCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        columIdentificacion.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().idUsuario()));

    }

    private void obtenerUsuarios() {
        listaUsuarios.addAll(usuarioController.obtenerUsuarios());
    }

    private void listenerSelection() {
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);
        });
    }

    private UsuarioDto crearUsuario() {

        return  new UsuarioDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCorreo.getText(),
                txtIdentificacion.getText()
        );
    }

    private void mostrarInformacionUsuario(UsuarioDto usuarioSeleccionado) {
        if(usuarioSeleccionado != null){
            txtNombre.setText(usuarioSeleccionado.nombre());
            txtApellido.setText(usuarioSeleccionado.apellido());
            txtIdentificacion.setText(usuarioSeleccionado.idUsuario());
            txtCorreo.setText(usuarioSeleccionado.correo());
        }
    }
}


