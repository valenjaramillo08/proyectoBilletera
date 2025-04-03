package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

public class Cuenta {
    public String idCuenta;
    public String nombreBanco;
    public String numeroCuenta;
    public TipoCuenta tipoCuenta;
    public Usuario usuarioAsociado;
    public Administrador administradorAsociado;

    public Cuenta(){}

    public Cuenta(String idCuenta,
                  String nombreBanco,
                  String numeroCuenta,
                  TipoCuenta tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }
}
