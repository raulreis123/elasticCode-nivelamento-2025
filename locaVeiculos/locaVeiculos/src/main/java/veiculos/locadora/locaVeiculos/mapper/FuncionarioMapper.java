package veiculos.locadora.locaVeiculos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Funcionario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    @Mapping(source = "nome", target = "nome")
    Funcionario toEntity(FuncionarioRequestDto requestDto);
    FuncionarioResponseDto toDto(Funcionario funcionario);
    List<FuncionarioResponseDto> toListDto(List<Funcionario> funcionarios);
}
