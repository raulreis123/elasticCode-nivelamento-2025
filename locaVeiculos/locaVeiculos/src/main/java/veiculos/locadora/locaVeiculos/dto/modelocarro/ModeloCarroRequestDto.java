package veiculos.locadora.locaVeiculos.dto.modelocarro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.dto.fabricante.FabricanteRequestDto;
import veiculos.locadora.locaVeiculos.entity.produto.Categoria;

@Getter
@Setter
public class ModeloCarroRequestDto {

    @NotBlank
    private String descricao;

    @NotNull
    private Categoria categoria;

    @NotNull
    private FabricanteRequestDto fabricante;
}
