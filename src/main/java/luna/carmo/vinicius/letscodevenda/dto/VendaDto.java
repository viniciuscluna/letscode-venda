package luna.carmo.vinicius.letscodevenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VendaDto {

    private String codigo;

    private double valorTotal;

    private VendaUsuarioDto usuarioDto;

    private List<VendaProdutoDto> produtos;
}
