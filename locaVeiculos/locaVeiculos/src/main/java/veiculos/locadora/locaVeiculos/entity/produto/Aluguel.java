package veiculos.locadora.locaVeiculos.entity.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Calendar dataPedido;

    @PastOrPresent
    private Date dataEntrega;

    @FutureOrPresent
    private Date dataDevolucao;

    @NotNull
    private BigDecimal valorTotal;

    @ManyToOne
    private Carro carro;

    @OneToOne
    private ApoliceSeguro apoliceSeguro;
    // Um aluguel pertence a um motorista
    // Um aluguel tem uma apólice
}
