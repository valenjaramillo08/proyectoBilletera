package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

import java.time.LocalDate;

public class Transaccion {
    public String idTransaccion;
    public TipoCuentaOrigen tipoCuentaOrigen;
    public LocalDate fechaTransaccion;
    public double monto;
    public String descripcion;
    public TipoCuenta tipoCuenta;

    public Transaccion() {}
    public Transaccion(
            String idTransaccion,
            TipoCuentaOrigen tipoCuentaOrigen,
            LocalDate fechaTransaccion,
            double monto,
            String descripcion,
            TipoCuenta tipoCuenta
    ){
        this.idTransaccion = idTransaccion;
        this.tipoCuentaOrigen = tipoCuentaOrigen;
        this.fechaTransaccion = fechaTransaccion;
        this.monto = monto;
        this.descripcion = descripcion;
        this.tipoCuenta = tipoCuenta;

    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public TipoCuentaOrigen getTipoCuentaOrigen() {
        return tipoCuentaOrigen;
    }

    public void setTipoCuentaOrigen(TipoCuentaOrigen tipoCuentaOrigen) {
        this.tipoCuentaOrigen = tipoCuentaOrigen;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
