package veiculos.locadora.locaVeiculos.dto.acessorios;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessorioRequestDto {

    @NotBlank
    private String descricao;
}
