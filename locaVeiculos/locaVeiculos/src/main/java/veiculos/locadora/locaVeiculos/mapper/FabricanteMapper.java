package veiculos.locadora.locaVeiculos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import veiculos.locadora.locaVeiculos.dto.fabricante.FabricanteRequestDto;
import veiculos.locadora.locaVeiculos.dto.fabricante.FabricanteResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Fabricante;

@Mapper(componentModel = "spring")
public interface FabricanteMapper {
    //@Mapping(target = "nome", source = "nome")
    Fabricante toEntity(FabricanteRequestDto fabricante);
    FabricanteResponseDto toDto(Fabricante fabricante);
}
