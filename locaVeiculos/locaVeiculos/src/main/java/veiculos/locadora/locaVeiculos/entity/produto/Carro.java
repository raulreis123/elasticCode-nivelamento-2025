package veiculos.locadora.locaVeiculos.entity.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    // Um carro pode ter apenas um modelo
    // Um carro pode ter nenhum ou varios acessorios
}
