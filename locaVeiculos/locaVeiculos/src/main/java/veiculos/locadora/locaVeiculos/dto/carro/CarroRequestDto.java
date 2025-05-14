package veiculos.locadora.locaVeiculos.dto.carro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioRequestDto;
import veiculos.locadora.locaVeiculos.dto.modelocarro.ModeloCarroRequestDto;
import veiculos.locadora.locaVeiculos.entity.produto.Acessorio;
import veiculos.locadora.locaVeiculos.entity.produto.ModeloCarro;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CarroRequestDto {

    @NotBlank
    private String placa;
    @NotBlank
    private String chassi;
    @NotBlank
    private String cor;
    @NotNull
    private BigDecimal valorDiaria;
    @NotNull
    private ModeloCarroRequestDto modelo;
    private List<AcessorioRequestDto> acessorios;
}
