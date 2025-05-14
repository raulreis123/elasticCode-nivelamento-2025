package veiculos.locadora.locaVeiculos.mapper;

import org.mapstruct.Mapper;
import veiculos.locadora.locaVeiculos.dto.carro.CarroRequestDto;
import veiculos.locadora.locaVeiculos.dto.carro.CarroResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Carro;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        ModeloCarroMapper.class,
        AcessorioMapper.class
})
public interface CarroMapper {
    Carro toEntity(CarroRequestDto dto);
    CarroResponseDto toDto(Carro carro);
    List<CarroResponseDto> toListDto(List<Carro> carros);
}
