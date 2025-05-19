package veiculos.locadora.locaVeiculos.dto.aluguel;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.produto.Carro;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class AluguelRequestDto {
    @NotNull
    private Calendar dataPedido;
    @PastOrPresent
    private Date dataEntrega;
    @FutureOrPresent
    private Date dataDevolucao;
    @NotNull
    private Carro carro;
}
