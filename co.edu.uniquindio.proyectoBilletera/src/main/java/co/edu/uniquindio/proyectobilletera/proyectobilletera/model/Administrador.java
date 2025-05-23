package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.IUsuarioServices;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.ICuentaServices;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona implements IUsuarioServices, ICuentaServices {
        public String idAdministrador;
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Transaccion> listaTransacciones = new ArrayList<>();
        List<Cuenta> listaCuentas = new ArrayList<>();

        Billetera billetera;

        public Administrador(Billetera billetera) {
            this.billetera = billetera;
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
                getListaUsuarios().remove(usuario);
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

                return true;
            }else{
                return false;
            }
        }

        public String getIdAdministrador() {
            return idAdministrador;
        }

        public void setIdAdministrador(String idAdministrador) {
            this.idAdministrador = idAdministrador;
        }

        public List<Usuario> getListaUsuarios() {
            return listaUsuarios;
        }

        public void setListaUsuarios(List<Usuario> listaUsuarios) {
            this.listaUsuarios = listaUsuarios;
        }

        public List<Transaccion> getListaTransacciones() {
            return listaTransacciones;
        }

        public void setListaTransacciones(List<Transaccion> listaTransacciones) {
            this.listaTransacciones = listaTransacciones;
        }

        public List<Cuenta> getListaCuentas() {
            return listaCuentas;
        }

        public void setListaCuentas(List<Cuenta> listaCuentas) {
            this.listaCuentas = listaCuentas;
        }

        @Override
        public boolean agregarCuenta(String idCuenta,String nombreBanco, String numeroCuenta,TipoCuenta tipoCuenta) {
            return billetera.agregarCuenta(idCuenta,nombreBanco,numeroCuenta,tipoCuenta);
        }

        @Override
        public boolean actualizarCuenta(String idCuenta, String idCuentaActual, String nombreBanco, String numeroCuenta,
                TipoCuenta tipoCuenta) {
                    return billetera.actualizarCuenta(idCuenta, idCuentaActual, nombreBanco, numeroCuenta, tipoCuenta);
        }

        @Override
        public boolean eliminarCuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta) {
            return billetera.eliminarCuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
        }    
}

