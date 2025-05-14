package veiculos.locadora.locaVeiculos.mapper;

import org.mapstruct.Mapper;
import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioRequestDto;
import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Acessorio;

@Mapper(componentModel = "spring")
public interface AcessorioMapper {
    Acessorio toEntity(AcessorioRequestDto acessorio);
    AcessorioResponseDto toDto(Acessorio acessorio);
}
