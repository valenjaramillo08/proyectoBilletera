package co.edu.uniquindio.proyectobilletera.proyectobilletera.viewcontroller;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.utils.BilleteraConstantes;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.controller.UsuarioController;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;
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

        private TableView<UsuarioDto> tableUsuarios;


        @FXML
        private Button btnAgregar;

        @FXML
        private TextField txtIdentificacion;

        @FXML
        private TextField txtCorreo;

        @FXML
        private Button btnActualizar;

        @FXML
        public void onAgregar(javafx.event.ActionEvent actionEvent) {
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
    private boolean datosValidos(UsuarioDto usuarioDto) {
        if(usuarioDto.nombre().isEmpty() ||
        usuarioDto.apellido().isEmpty() ||
        usuarioDto.idUsuario().isEmpty() ||
        usuarioDto.correo().isEmpty()) {
         return false;
     }else{
         return true;
     }
       
    }



    @FXML
    public void onActualizar(javafx.event.ActionEvent actionEvent) {

    }

     public Usuario actualizarUsuario(String idUsuario, UsuarioDto usuarioDto) {
        
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                
                usuario.setNombre(usuarioDto.getNombre());
                usuario.setApellido(usuarioDto.getApellido());
                usuario.setIdUsuario(usuarioDto.getIdUsuario());
                usuario.setCorreo(usuarioDto.getCorreo());


              
                return usuario;
            }else{
                System.out.println("Usuario no encontrado");
            }
        

        
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
        columApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        columIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idUsuario()));
        columCorreo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().correo()));

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
                txtIdentificacion.getText(),
                txtCorreo.getText()
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

    public void onNuevo(javafx.event.ActionEvent actionEvent) {
    }




}


