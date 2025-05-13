package veiculos.locadora.locaVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veiculos.locadora.locaVeiculos.entity.usuario.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {
}
