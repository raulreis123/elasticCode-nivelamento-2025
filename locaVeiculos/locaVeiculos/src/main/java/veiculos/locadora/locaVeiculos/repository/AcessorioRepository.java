package veiculos.locadora.locaVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veiculos.locadora.locaVeiculos.entity.produto.Acessorio;

import java.util.Optional;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {

    Optional<Acessorio> findByDescricaoIgnoreCase(String descricao);
}
