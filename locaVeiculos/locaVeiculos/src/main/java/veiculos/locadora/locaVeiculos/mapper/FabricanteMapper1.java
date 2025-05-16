package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.fabricante.FabricanteRequestDto;
import veiculos.locadora.locaVeiculos.dto.fabricante.FabricanteResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Fabricante;

public class FabricanteMapper1 {
    Fabricante toEntity(FabricanteRequestDto dto){
        Fabricante fabricante = new Fabricante();

        fabricante.setNome(dto.getNome());

        return fabricante;
    }

    FabricanteResponseDto toDto(Fabricante fabricante){
        FabricanteResponseDto dto = new FabricanteResponseDto();

        dto.setNome(fabricante.getNome());

        return dto;
    }
}
