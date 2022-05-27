package luna.carmo.vinicius.letscodevenda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Venda {

    @NotBlank
    @Id
    private String codigo;

    private Date dataCompra;

    private String descricao;

    private VendaUsuario usuario;

    private List<VendaProduto> produtos;
}
