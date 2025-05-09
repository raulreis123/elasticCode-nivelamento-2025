package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Funcionario;

public class FuncionarioMapper {
    public Funcionario toEntity(FuncionarioRequestDto request){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(request.getNome());
        funcionario.setDataNasc(request.getDataNasc());
        funcionario.setCpf(request.getCpf());
        funcionario.setSexo(request.getSexo());

        return funcionario;
    }

    public FuncionarioResponseDto toDto(Funcionario funcionario){
        FuncionarioResponseDto dto = new FuncionarioResponseDto();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setSexo(funcionario.getSexo());

        return dto;
    }
}
