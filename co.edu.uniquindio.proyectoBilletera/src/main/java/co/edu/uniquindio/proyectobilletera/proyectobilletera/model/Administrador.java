package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona implements IUsuarioServices {
        public String idAdministrador;
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Transaccion> listaTransacciones = new ArrayList<>();
        List<Cuenta> listaCuentas = new ArrayList<>();

        public Administrador() {
        }

        public Administrador (String nombre,
                              String apellido,
                              String correo,
                              String idAdministrador){
            super(nombre,apellido,correo);
            this.idAdministrador = idAdministrador;

        }

        @Override
        public boolean agregarUsuario(String nombre, String apellido, String correo, String telefono, String idUsuario, String direccion) {
            Usuario usuario = obtenerUsuario(idUsuario);
            if(usuario == null){
                usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuario.setCorreo(correo);
                usuario.setTelefono(telefono);
                usuario.setIdUsuario(idUsuario);
                usuario.setDireccion(direccion);
                getListaUsuarios().add(usuario);

                return true;
            }else{
                return false;
            }
        }

        @Override
        public Usuario obtenerUsuario(String idUsuario) {

            Usuario usuarioEncontrado = null;
            for (Usuario usuario: getListaUsuarios()) {
                if(usuario.getIdUsuario().equalsIgnoreCase(idUsuario)){
                    usuarioEncontrado = usuario;
                    break;
                }
            }

            return usuarioEncontrado;

        }

        @Override
        public boolean eliminarUsuario(String idUsuario) {

            Usuario usuario = obtenerUsuario(idUsuario);
            if(usuario != null){
                getListaUsuario().remove(usuario);
                return true;
            }else{
                return false;
            }

        }

        @Override
        public boolean actualizarUsuario(String nombre, String apellido, String correo, String telefono, String idUsuarioActual, String idUsuario, String direccion) {
            Usuario usuario = obtenerUsuario(idUsuarioActual);
            if(usuario != null){
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuario.setCorreo(correo);
                usuario.setTelefono(telefono);
                usuario.setIdUsuario(usuario);
                usuario.setDireccion(direccion);


                return true;
            }else{
                return false;
            }
        }
}

