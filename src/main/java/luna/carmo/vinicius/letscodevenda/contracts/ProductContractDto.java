package luna.carmo.vinicius.letscodevenda.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductContractDto {
    private String id;
    private String name;
    private float price;
}
