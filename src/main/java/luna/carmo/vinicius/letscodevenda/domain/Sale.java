package luna.carmo.vinicius.letscodevenda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Sale {
    @Id
    private String code;

    private float totalPrice;

    private Date date;

    private SaleUser user;

    private List<SaleProduct> products;
}
