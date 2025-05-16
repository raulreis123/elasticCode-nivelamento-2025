package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioMapper1 {
    Funcionario toEntity(FuncionarioRequestDto dto){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(dto.getNome());
        funcionario.setDataNasc(dto.getDataNasc());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSexo(dto.getSexo());
        funcionario.setMatricula(dto.getMatricula());

        return funcionario;
    }

    FuncionarioResponseDto toDto(Funcionario funcionario){
        FuncionarioResponseDto dto = new FuncionarioResponseDto();

        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setSexo(funcionario.getSexo());

        return dto;
    }

    List<FuncionarioResponseDto> toListDto(List<Funcionario> funcionarios){
        List<FuncionarioResponseDto> listDto = new ArrayList<>();

        for(Funcionario func : funcionarios){
            listDto.add(toDto(func));
        }

        return listDto;
    }
}
