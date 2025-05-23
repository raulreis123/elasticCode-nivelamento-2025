package veiculos.locadora.locaVeiculos.entity.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal valorFranquia;

    @NotNull
    private Boolean protecaoTerceiro;

    @NotNull
    private Boolean protecaoCausasNaturais;

    @NotNull
    private Boolean protecaoRoubo;
    // Uma apolice tem um seguro
}
