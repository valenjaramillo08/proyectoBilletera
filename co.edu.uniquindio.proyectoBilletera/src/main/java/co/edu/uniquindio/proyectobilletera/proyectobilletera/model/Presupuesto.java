package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
    public String idPresupuesto;
    public String nombrePresupuesto;
    public double montoPresupuesto;
    public double montoPresupuestoGastado;
    List<Categoria> listaCategorias = new ArrayList<>();
    public Usuario usuarioAsociado;

    public Presupuesto() {}
    public Presupuesto(String idPresupuesto,
                       String nombrePresupuesto,
                       double montoPresupuesto,
                       double montoPresupuestoGastado) {
        this.idPresupuesto = idPresupuesto;
        this.nombrePresupuesto = nombrePresupuesto;
        this.montoPresupuesto = montoPresupuesto;
        this.montoPresupuestoGastado= montoPresupuestoGastado;
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getNombrePresupuesto() {
        return nombrePresupuesto;
    }

    public void setNombrePresupuesto(String nombrePresupuesto) {
        this.nombrePresupuesto = nombrePresupuesto;
    }

    public double getMontoPresupuesto() {
        return montoPresupuesto;
    }

    public void setMontoPresupuesto(double montoPresupuesto) {
        this.montoPresupuesto = montoPresupuesto;
    }

    public double getMontoPresupuestoGastado() {
        return montoPresupuestoGastado;
    }

    public void setMontoPresupuestoGastado(double montoPresupuestoGastado) {
        this.montoPresupuestoGastado = montoPresupuestoGastado;
    }
}
