package luna.carmo.vinicius.letscodevenda.repositories;

import luna.carmo.vinicius.letscodevenda.domain.Sale;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends ReactiveCrudRepository<Sale, String> {
}
