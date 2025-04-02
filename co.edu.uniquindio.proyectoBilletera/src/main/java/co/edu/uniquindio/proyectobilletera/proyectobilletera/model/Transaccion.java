package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

import java.time.LocalDate;

public class Transaccion {
    public String idTransaccion;
    public TipoCuentaOrigen tipoCuenta;
    public LocalDate fechaTransaccion;
    public double monto;
    public String descripcion;
    public TipoCuentaOrigen tipoCuentaOrigen;
    public TipoCuenta tipoCuenta;
}
