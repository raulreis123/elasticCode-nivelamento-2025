package veiculos.locadora.locaVeiculos.mapper;

import org.mapstruct.Mapper;
import veiculos.locadora.locaVeiculos.dto.modelocarro.ModeloCarroRequestDto;
import veiculos.locadora.locaVeiculos.dto.modelocarro.ModeloCarroResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.ModeloCarro;

@Mapper(componentModel = "spring", uses = { FabricanteMapper.class })
public interface ModeloCarroMapper {
    ModeloCarro toEntity(ModeloCarroRequestDto modelo);
    ModeloCarroResponseDto toDto(ModeloCarro modelo);
}
