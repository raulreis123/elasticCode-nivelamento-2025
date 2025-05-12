package veiculos.locadora.locaVeiculos.mapper;

import org.mapstruct.Mapper;
import veiculos.locadora.locaVeiculos.dto.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Funcionario;

@Mapper(componentModel = "spring")
public interface FuncionarioMapperStruct {
    Funcionario toEntity(FuncionarioRequestDto requestDto);
    FuncionarioResponseDto toDto(Funcionario funcionario);
}
