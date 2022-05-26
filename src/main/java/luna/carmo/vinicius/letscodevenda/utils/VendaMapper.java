package luna.carmo.vinicius.letscodevenda.utils;

import lombok.RequiredArgsConstructor;
import luna.carmo.vinicius.letscodevenda.domain.Venda;
import luna.carmo.vinicius.letscodevenda.dto.VendaDto;
import luna.carmo.vinicius.letscodevenda.dto.VendaProdutoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendaMapper {

    private final VendaUsuarioMapper vendaUsuarioMapper;


    public Flux<VendaDto> map(Flux<Venda> venda){
        return venda.map(m -> new VendaDto(m.getCodigo(), 0, vendaUsuarioMapper.map(m.getUsuario()) , m.getProdutos().stream()
                        .map(p ->  new VendaProdutoDto(p.getNome(),p.getValor()))
                        .collect(Collectors.toList()))
                );
    }

    public Mono<VendaDto> map(Mono<Venda> venda){
        return venda.map(m -> new VendaDto(m.getCodigo(), 0, vendaUsuarioMapper.map(m.getUsuario()) , m.getProdutos().stream()
                .map(p -> new VendaProdutoDto(p.getNome(),p.getValor()))
                .collect(Collectors.toList()))
        );
    }

    public VendaDto map(Venda venda){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(venda, VendaDto.class);
    }


    public Venda map(VendaDto venda) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(venda, Venda.class);
    }
}
