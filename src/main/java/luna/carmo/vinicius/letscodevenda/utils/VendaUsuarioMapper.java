package luna.carmo.vinicius.letscodevenda.utils;

import luna.carmo.vinicius.letscodevenda.domain.VendaUsuario;
import luna.carmo.vinicius.letscodevenda.dto.VendaUsuarioDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VendaUsuarioMapper {
    public VendaUsuarioDto map(VendaUsuario vendaUsuario){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vendaUsuario, VendaUsuarioDto.class);
    }

    public VendaUsuario map(VendaUsuarioDto vendaUsuario){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vendaUsuario, VendaUsuario.class);
    }
}
