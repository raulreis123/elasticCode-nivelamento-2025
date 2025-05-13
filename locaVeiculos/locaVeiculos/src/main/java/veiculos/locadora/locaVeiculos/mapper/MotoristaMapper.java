package veiculos.locadora.locaVeiculos.mapper;

import org.mapstruct.Mapper;
import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaRequestDto;
import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Motorista;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MotoristaMapper {
    Motorista toEntity(MotoristaRequestDto dto);
    MotoristaResponseDto toDto(Motorista motorista);
    List<MotoristaResponseDto> toListDto(List<Motorista> motoristas);
}
