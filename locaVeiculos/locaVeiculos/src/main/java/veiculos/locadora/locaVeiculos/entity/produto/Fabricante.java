package veiculos.locadora.locaVeiculos.entity.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante {
    private String nome;
    // Uma fabricante poder ter nenhum ou varios modelos
}
