package luna.carmo.vinicius.letscodevenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {
    private String code;

    private float totalPrice;

    private Date date;

    private SaleUserDto user;

    private List<SaleProductDto> products;
}
