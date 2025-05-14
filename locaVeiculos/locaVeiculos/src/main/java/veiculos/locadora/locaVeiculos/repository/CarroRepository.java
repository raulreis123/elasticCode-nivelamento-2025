package veiculos.locadora.locaVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veiculos.locadora.locaVeiculos.entity.produto.Carro;
import veiculos.locadora.locaVeiculos.entity.produto.Categoria;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByModelo_Categoria(Categoria categoria);
    List<Carro> findDistinctByAcessorios_DescricaoInIgnoreCase(List<String> descricoes);

}
