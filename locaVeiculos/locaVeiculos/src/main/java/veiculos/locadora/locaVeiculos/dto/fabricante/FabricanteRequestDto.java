package veiculos.locadora.locaVeiculos.dto.fabricante;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FabricanteRequestDto {

    @NotNull
    private String nome;
}
