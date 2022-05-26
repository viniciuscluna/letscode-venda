package luna.carmo.vinicius.letscodevenda.services;

import lombok.RequiredArgsConstructor;
import luna.carmo.vinicius.letscodevenda.domain.Venda;
import luna.carmo.vinicius.letscodevenda.domain.VendaProduto;
import luna.carmo.vinicius.letscodevenda.dto.VendaDto;
import luna.carmo.vinicius.letscodevenda.dto.VendaProdutoDto;
import luna.carmo.vinicius.letscodevenda.repositories.VendaRepository;
import luna.carmo.vinicius.letscodevenda.utils.VendaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository repository;
    private final VendaMapper mapper;

    public Flux<VendaDto> getVendas(){
        return mapper.map(repository.findAll());

    }

    public Mono<VendaDto> inserirVenda(VendaDto venda){
        Venda mappedVenda = mapper.map(venda);
        mappedVenda.setCodigo(java.util.UUID.randomUUID().toString());
        mappedVenda.setDataCompra(new Date());
        var result = repository.save(mappedVenda);
        return mapper.map(result);
    }

}
