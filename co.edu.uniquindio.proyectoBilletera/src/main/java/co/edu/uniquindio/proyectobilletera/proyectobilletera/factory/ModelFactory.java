package co.edu.uniquindio.proyectobilletera.proyectobilletera.factory;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.mappers.BilleteraMapping;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Administrador;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Billetera;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Cuenta;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.TipoCuenta;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.IBilleteraMapping;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.ICuentaServices;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.IModelFactoryServices;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.utils.DataUtil;
import java.util.List;

public class ModelFactory implements IModelFactoryServices, ICuentaServices {
    private static ModelFactory modelFactory;
    private Billetera billetera;
    private IBilleteraMapping mapper;
    private Administrador administrador;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new BilleteraMapping();
        billetera = DataUtil.inicializarDatos();
        administrador = new Administrador(billetera);
    }

    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return mapper.getUsuariosDto(billetera.getListaUsuarios());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
        return billetera.crearUsuario(usuario);
    }

    @Override
    public boolean actualizarUsuario(String idUsuario,UsuarioDto usuarioDto) {
        Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
        return billetera.actualizarUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getTelefono(),idUsuario,usuario.getIdUsuario(), usuario.getDireccion());
    }

    @Override
    public boolean eliminarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
        return billetera.eliminarUsuario(usuario);
    }

    @Override
    public boolean agregarCuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta) {
        return administrador.agregarCuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
    }

    @Override
    public boolean actualizarCuenta(String idCuenta, String idCuentaActual, String nombreBanco, String numeroCuenta,
            TipoCuenta tipoCuenta) {
        return administrador.actualizarCuenta(idCuenta, idCuentaActual, nombreBanco, numeroCuenta, tipoCuenta);
    }

    @Override
    public boolean eliminarCuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta) {
        return administrador.eliminarCuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
    }

    public List<Cuenta> obtenerCuentas() {
        return billetera.getListaCuentas();
    }

}
