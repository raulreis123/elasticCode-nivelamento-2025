package veiculos.locadora.locaVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veiculos.locadora.locaVeiculos.entity.produto.Fabricante;

import java.util.Optional;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    Optional<Fabricante> findByNomeIgnoreCase(String nome);
}
