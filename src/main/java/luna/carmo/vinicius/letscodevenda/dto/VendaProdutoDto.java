package luna.carmo.vinicius.letscodevenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VendaProdutoDto {
    private String nome;
    private float valor;
}
