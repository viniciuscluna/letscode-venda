package luna.carmo.vinicius.letscodevenda.repositories;

import luna.carmo.vinicius.letscodevenda.domain.Venda;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends ReactiveCrudRepository<Venda, String> {
}
