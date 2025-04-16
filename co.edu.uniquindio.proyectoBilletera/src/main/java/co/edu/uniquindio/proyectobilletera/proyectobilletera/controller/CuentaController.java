package co.edu.uniquindio.proyectobilletera.proyectobilletera.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.factory.ModelFactory;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Cuenta;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.TipoCuenta;

public class CuentaController {

    ModelFactory modelFactory;

    public CuentaController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public boolean agregarCuenta(String idCuenta,String nombreBanco, String numeroCuenta,TipoCuenta tipoCuenta){
        return modelFactory.agregarCuenta(idCuenta,nombreBanco,numeroCuenta,tipoCuenta);
    }

    public Collection<Cuenta> obtenerListaCuentas(){
        return modelFactory.obtenerCuentas();
    }

    public boolean eliminarCuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta){
        return modelFactory.eliminarCuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
    }

    public boolean actualizarCuenta(String idCuenta, String idCuentaActual, String nombreBanco, String numeroCuenta,
    TipoCuenta tipoCuenta){
        return modelFactory.actualizarCuenta(idCuenta, idCuentaActual, nombreBanco, numeroCuenta, tipoCuenta);
    }
    public List<Cuenta> obtenerCuentas(){
        return new ArrayList<>(modelFactory.obtenerCuentas());
    }
}
