package luna.carmo.vinicius.letscodevenda.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VendaProduto {
    private String nome;
    private float valor;
}
