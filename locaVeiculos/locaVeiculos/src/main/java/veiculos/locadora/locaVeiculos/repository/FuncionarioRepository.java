package veiculos.locadora.locaVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veiculos.locadora.locaVeiculos.entity.usuario.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
