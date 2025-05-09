package veiculos.locadora.locaVeiculos.entity.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acessorio {
    private String descricao;
    // Um acessorio pode estar presente em nenhum ou varios carros
}
