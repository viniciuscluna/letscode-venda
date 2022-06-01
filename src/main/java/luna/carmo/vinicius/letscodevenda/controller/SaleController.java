package luna.carmo.vinicius.letscodevenda.controller;

import lombok.RequiredArgsConstructor;
import luna.carmo.vinicius.letscodevenda.dto.SaleDto;
import luna.carmo.vinicius.letscodevenda.dto.SaleRequestDto;
import luna.carmo.vinicius.letscodevenda.services.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<SaleDto> getSaleById(@PathVariable String id){
        return service.getSaleById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<SaleDto> getSales(){
        return service.getSales();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public Mono<SaleDto> persistSale(@Valid @RequestBody SaleRequestDto saleRequestDto) {
        return service.persistSale(saleRequestDto);
    }

}
