package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.modelocarro.ModeloCarroRequestDto;
import veiculos.locadora.locaVeiculos.dto.modelocarro.ModeloCarroResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.ModeloCarro;

public class ModeloCarroMapper1 {
    FabricanteMapper1 mapper = new FabricanteMapper1();

    public ModeloCarro toEntity(ModeloCarroRequestDto dto){
        ModeloCarro modelo = new ModeloCarro();

        modelo.setDescricao(dto.getDescricao());
        modelo.setCategoria(dto.getCategoria());
        modelo.setFabricante(mapper.toEntity(dto.getFabricante()));

        return modelo;
    }

    public ModeloCarroResponseDto toDto(ModeloCarroRequestDto request){
        ModeloCarroResponseDto dto = new ModeloCarroResponseDto();

        dto.setDescricao(request.getDescricao());

        return dto;
    }

    public ModeloCarroResponseDto toDto(ModeloCarro modelo){
        ModeloCarroResponseDto dto = new ModeloCarroResponseDto();

        dto.setDescricao(modelo.getDescricao());

        return dto;
    }
}
