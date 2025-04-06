package co.edu.uniquindio.proyectobilletera.proyectobilletera.service;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;

import java.util.List;

public interface IModelFactoryServices {
    public List<UsuarioDto> obtenerUsuarios();

    boolean agregarUsuario(UsuarioDto usuarioDto);
    boolean actualizarUsuario(String idUsuario,UsuarioDto usuarioDto);
    boolean eliminarUsuario(UsuarioDto usuarioDto);
}
