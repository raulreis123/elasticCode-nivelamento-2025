package veiculos.locadora.locaVeiculos.entity.usuario;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Motorista extends Pessoa {
    private String numeroCNH;

    // Um motorista pode possuir diversos alugueis
}
