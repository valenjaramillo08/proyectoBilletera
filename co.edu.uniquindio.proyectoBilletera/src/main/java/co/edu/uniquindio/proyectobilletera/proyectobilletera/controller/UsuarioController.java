package co.edu.uniquindio.proyectobilletera.proyectobilletera.controller;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.factory.ModelFactory;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;



import java.util.List;

public class UsuarioController {
    ModelFactory modelFactory;
    public UsuarioController(){

        modelFactory = ModelFactory.getInstancia();
    }

    public List<UsuarioDto> obtenerUsuarios() {

        return modelFactory.obtenerUsuarios();
    }

    public boolean agregarUsuario(UsuarioDto usuarioDto) {

        return modelFactory.agregarUsuario(usuarioDto);
    }
    public boolean actualizarUsuario(String idUsuario, UsuarioDto usuarioDto) {
        return modelFactory.actualizarUsuario(idUsuario ,usuarioDto);
    }
    public boolean eliminarUsuario(UsuarioDto usuarioDto) {
        return modelFactory.eliminarUsuario(usuarioDto);
    }
}
