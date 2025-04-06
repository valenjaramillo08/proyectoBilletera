package co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.mappers;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.IBilleteraMapping;

import java.util.ArrayList;
import java.util.List;

public class BilleteraMapping implements IBilleteraMapping {


    @Override
    public List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios) {
        if(listaUsuarios == null){
            return null;
        }
        List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>(listaUsuarios.size());
        for(Usuario usuario : listaUsuarios){
            listaUsuariosDto.add(usuarioToUsuarioDto(usuario));
        }
        return listaUsuariosDto;
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getIdUsuario(),
                usuario.getCorreo());
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .nombre(usuarioDto.nombre())
                .apellido(usuarioDto.apellido())
                .correo(usuarioDto.correo())
                .idUsuario(usuarioDto.idUsuario())
                .build();


        }
    }