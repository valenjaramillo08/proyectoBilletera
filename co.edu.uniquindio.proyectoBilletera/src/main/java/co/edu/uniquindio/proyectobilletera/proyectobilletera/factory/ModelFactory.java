package co.edu.uniquindio.proyectobilletera.proyectobilletera.factory;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.mapping.mappers.BilleteraMapping;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Billetera;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.IBilleteraMapping;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.service.IModelFactoryServices;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.utils.DataUtil;
import java.util.List;

public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory modelFactory;
    private Billetera billetera;
    private IBilleteraMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new BilleteraMapping();
        billetera = DataUtil.inicializarDatos();
    }

    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return mapper.getUsuariosDto(billetera.getListaClientes());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return false;
    }
}
