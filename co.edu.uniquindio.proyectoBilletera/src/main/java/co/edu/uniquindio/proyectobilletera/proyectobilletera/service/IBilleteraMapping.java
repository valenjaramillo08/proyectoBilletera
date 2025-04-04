package co.edu.uniquindio.proyectobilletera.proyectobilletera.service;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;

import java.util.List;

public interface IBilleteraMapping {
    List<UsuarioDto> getUsuariosDto (List<Usuario> listaUsuarios);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
    
}
