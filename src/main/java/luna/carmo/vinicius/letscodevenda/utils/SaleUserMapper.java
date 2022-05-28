package luna.carmo.vinicius.letscodevenda.utils;

import luna.carmo.vinicius.letscodevenda.domain.SaleUser;
import luna.carmo.vinicius.letscodevenda.dto.SaleUserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SaleUserMapper {
    public SaleUserDto map(SaleUser vendaUsuario){
        if(vendaUsuario==null)return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vendaUsuario, SaleUserDto.class);
    }

    public SaleUser map(SaleUserDto vendaUsuario){
        if(vendaUsuario==null)return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vendaUsuario, SaleUser.class);
    }
}
