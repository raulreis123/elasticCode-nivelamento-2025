package veiculos.locadora.locaVeiculos.dto.aluguel;

import lombok.Getter;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.produto.Carro;

import java.math.BigDecimal;

@Getter
@Setter
public class AluguelResponseDto {
    private Long id;
    private BigDecimal valorTotal;
    private Carro carro;
}
