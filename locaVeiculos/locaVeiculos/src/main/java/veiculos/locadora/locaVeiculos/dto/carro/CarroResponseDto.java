package veiculos.locadora.locaVeiculos.dto.carro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioResponseDto;
import veiculos.locadora.locaVeiculos.dto.modelocarro.ModeloCarroResponseDto;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarroResponseDto {

    private BigDecimal valorDiaria;

    private ModeloCarroResponseDto modelo;

    private List<AcessorioResponseDto> acessorios;
}
