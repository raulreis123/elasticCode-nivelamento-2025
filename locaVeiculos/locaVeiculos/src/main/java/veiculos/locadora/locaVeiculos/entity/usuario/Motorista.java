package veiculos.locadora.locaVeiculos.entity.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.produto.Aluguel;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Motorista extends Pessoa {
    private String numeroCNH;

    @OneToMany
    private List<Aluguel> aluguel;
    // Um motorista pode possuir diversos alugueis
}
