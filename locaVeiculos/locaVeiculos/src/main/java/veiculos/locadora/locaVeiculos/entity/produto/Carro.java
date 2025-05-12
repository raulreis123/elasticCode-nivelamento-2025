package veiculos.locadora.locaVeiculos.entity.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String chassi;

    @NotBlank
    private String cor;

    @NotNull
    private BigDecimal valorDiaria;
    // Um carro pode ter apenas um modelo
    // Um carro pode ter nenhum ou varios acessorios

    @ManyToMany
    private List<Acessorio> acessorio;
}
