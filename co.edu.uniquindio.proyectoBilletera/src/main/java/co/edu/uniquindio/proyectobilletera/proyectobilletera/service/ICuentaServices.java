package co.edu.uniquindio.proyectobilletera.proyectobilletera.service;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Cuenta;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.TipoCuenta;

public interface ICuentaServices {

    boolean agregarCuenta(String idCuenta,String nombreBanco, String numeroCuenta,TipoCuenta tipoCuenta);
    boolean actualizarCuenta(String idCuenta,String idCuentaActual,String nombreBanco, String numeroCuenta,TipoCuenta tipoCuenta);
    boolean eliminarCuenta(String idCuenta,String nombreBanco,String numeroCuenta,TipoCuenta tipoCuenta);
}




