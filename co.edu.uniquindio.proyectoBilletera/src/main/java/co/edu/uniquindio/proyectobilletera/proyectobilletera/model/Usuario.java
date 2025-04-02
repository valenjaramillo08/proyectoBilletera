package co.edu.uniquindio.proyectobilletera.proyectobilletera.model;

public class Usuario extends Persona {
    public String telefono;
    public String idUsuario;
    public String direccion;
    public double saldoDisponible;
    public List<Cuenta> listaCuentas = new ArrayList<>();
    public List<Transaccion> listaTransacciones = new ArrayList<>();
    public List<Presupuesto> listaPresupuestos = new ArrayList<>();

    public Usuario(){}

    public  Usuario(String nombre,
                    String apellido,
                    String correo,
                    String telefono,
                    String idUsuario,
                    String direccion,
                    double saldoDisponible,
                    ){
        super(nombre,apellido,correo);
        this.telefono = telefono;
        this.idUsuario = idUsuario;
        this.direccion = direccion;
        this.saldoDisponible = saldoDisponible;

    }
}
