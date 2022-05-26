package luna.carmo.vinicius.letscodevenda.controller;

import lombok.RequiredArgsConstructor;
import luna.carmo.vinicius.letscodevenda.dto.VendaDto;
import luna.carmo.vinicius.letscodevenda.services.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/venda")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<VendaDto> getVendas(){
        return service.getVendas();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<VendaDto> setVenda(@Valid @RequestBody VendaDto venda){
        return service.inserirVenda(venda);
    }

}
