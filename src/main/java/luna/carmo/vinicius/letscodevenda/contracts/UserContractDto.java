package luna.carmo.vinicius.letscodevenda.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContractDto {
    private String id;
    private String firstName;
    private String lastName;
    private String cep;
}
