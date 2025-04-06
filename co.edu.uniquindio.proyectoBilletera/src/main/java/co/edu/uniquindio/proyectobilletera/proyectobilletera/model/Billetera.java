package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

import java.util.ArrayList;
import java.util.List;

public class Billetera {
    List<Cuenta> listaCuentas = new ArrayList<>();
    List<Presupuesto> listaPresupuestos = new ArrayList<>();
    List<Transaccion> listaTransaccioness = new ArrayList<>();
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Administrador> listaAdministradores = new ArrayList<>();
    List<Categoria> listaCategorias = new ArrayList<>();

    public boolean crearUsuario(String nombre,
                                String apellido,
                                String correo,
                                String telefono,
                                String idUsuario,
                                String direccion,
                                double saldoDisponible){
        Usuario usuarioEncontrado = obtenerUsuario(idUsuario);
        if(usuarioEncontrado == null){
            Usuario usuario = getBuildUsuario(nombre, apellido, correo, telefono,idUsuario,direccion, saldoDisponible);
            getListaUsuarios().add(usuario);
            return true;
        }else{
            return  false;
        }
    }

    public boolean crearUsuario(Usuario nuevoUsuario){
        Usuario usuarioEncontrado = obtenerUsuario(nuevoUsuario.getIdUsuario());
        if(usuarioEncontrado == null){
            getListaUsuarios().add(nuevoUsuario);
            return true;
        }else{
            return  false;
        }
    }

    private Usuario getBuildUsuario(String nombre, String apellido, String correo, String telefono, String idUsuario, String direccion, double saldoDisponible) {
        return Usuario.builder()
                .nombre(nombre)
                .apellido(apellido)
                .correo(correo)
                .telefono(telefono)
                .idUsuario(idUsuario)
                .direccion(direccion)
                .saldoDisponible(saldoDisponible)
                .build();
    }

    private Usuario obtenerUsuario(String idUsuario) {
        Usuario usuario = null;
        for (Usuario usuario1 : getListaUsuarios()) {
            if (usuario1.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                usuario = usuario1;
                break;
            }
        }
        return usuario;
    }

    public boolean actualizarUsuario(String nombre, String apellido, String correo, String telefono, String idUsuarioActual, String idUsuario, String direccion) {
        Usuario usuarioExistente = obtenerUsuario(idUsuarioActual);

        if (usuarioExistente != null) {

            // Construir un nuevo objeto Usuario usando el builder y valores actualizados
            Usuario usuarioActualizado = Usuario.builder()
                    .nombre(nombre)
                    .apellido(apellido)
                    .correo(correo)
                    .telefono(telefono)
                    .idUsuario(idUsuario)
                    .direccion(direccion)
                    .saldoDisponible(usuarioExistente.getSaldoDisponible()) // mantener el saldo anterior
                    .build();

            // Reemplazar el usuario en la lista
            listaUsuarios.remove(usuarioExistente);
            listaUsuarios.add(usuarioActualizado);

            return true;
        }

        return false;
    }

    public boolean eliminarUsuario(Usuario usuario) {

        Usuario usuario1 = obtenerUsuario(usuario.getIdUsuario());
        if(usuario1 != null){
            getListaUsuarios().remove(usuario1);
            return true;
        }else{
            return false;
        }

    }


    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public List<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    public void setListaPresupuestos(List<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }

    public List<Transaccion> getListaTransaccioness() {
        return listaTransaccioness;
    }

    public void setListaTransaccioness(List<Transaccion> listaTransaccioness) {
        this.listaTransaccioness = listaTransaccioness;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

}
