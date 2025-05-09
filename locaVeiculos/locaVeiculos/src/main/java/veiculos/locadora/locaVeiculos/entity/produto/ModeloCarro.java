package veiculos.locadora.locaVeiculos.entity.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloCarro {
    private String descricao;
    private Categoria categoria;
    // Modelo é a composição de carro, ou seja carro não existe sem modelo
    // Um modelo pode ter nenhum ou varios carros
    // Um modelo pode ter apenas uma fabricante
}
