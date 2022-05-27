package luna.carmo.vinicius.letscodevenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VendaDto {

    private String codigo;

    private double valorTotal;

    @NotNull
    private VendaUsuarioDto usuario;

    @NotEmpty
    private List<VendaProdutoDto> produtos;
}
