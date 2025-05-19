package veiculos.locadora.locaVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veiculos.locadora.locaVeiculos.entity.produto.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
