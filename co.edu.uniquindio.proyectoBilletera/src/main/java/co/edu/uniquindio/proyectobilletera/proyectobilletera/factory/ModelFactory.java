package co.edu.uniquindio.proyectobilletera.proyectobilletera.factory;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.IModelFactoryServices;

import java.util.List;

public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory modelFactory;


    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return List.of();
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return false;
    }
}
