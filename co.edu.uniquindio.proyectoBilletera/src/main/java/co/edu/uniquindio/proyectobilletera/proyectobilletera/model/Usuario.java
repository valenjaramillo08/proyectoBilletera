package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.builder.UsuarioBuilder;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    public String telefono;
    public String idUsuario;
    public String direccion;
    public double saldoDisponible;
    public List<Cuenta> listaCuentas = new ArrayList<>();
    public List<Transaccion> listaTransacciones = new ArrayList<>();
    public List<Presupuesto> listaPresupuestos = new ArrayList<>();
    public List<Categoria> listaCategorias = new ArrayList<>();
    public Administrador administradorAsociado;
    



    public  Usuario() {

    }
    public  Usuario(String nombre,
                    String apellido,
                    String correo,
                    String telefono,
                    String idUsuario,
                    String direccion,
                    double saldoDisponible
                    ){
        super(nombre,apellido,correo);
        this.telefono = telefono;
        this.idUsuario = idUsuario;
        this.direccion = direccion;
        this.saldoDisponible = saldoDisponible;

    }
    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public List<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }
}
