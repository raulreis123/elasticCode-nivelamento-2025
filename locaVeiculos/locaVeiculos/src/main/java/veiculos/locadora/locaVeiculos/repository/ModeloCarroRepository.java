package veiculos.locadora.locaVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veiculos.locadora.locaVeiculos.entity.produto.ModeloCarro;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}
