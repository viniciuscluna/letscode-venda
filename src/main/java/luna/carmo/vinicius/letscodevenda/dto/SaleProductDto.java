package luna.carmo.vinicius.letscodevenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaleProductDto {
    private String id;
    private String name;
    private float price;
}
