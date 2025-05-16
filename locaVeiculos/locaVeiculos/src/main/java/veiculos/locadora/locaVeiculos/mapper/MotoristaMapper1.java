package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaRequestDto;
import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Motorista;

import java.util.ArrayList;
import java.util.List;

public class MotoristaMapper1 {
    Motorista toEntity(MotoristaRequestDto request){
        Motorista motorista = new Motorista();

        motorista.setNome(request.getNome());
        motorista.setDataNasc(request.getDataNasc());
        motorista.setCpf(request.getCpf());
        motorista.setEmail(request.getEmail());
        motorista.setSexo(request.getSexo());
        motorista.setNumeroCNH(request.getNumeroCNH());

        return motorista;
    }

    MotoristaResponseDto toDto(Motorista motorista){
        MotoristaResponseDto dto = new MotoristaResponseDto();

        dto.setId(motorista.getId());
        dto.setNome(motorista.getNome());

        return dto;
    }

    List<MotoristaResponseDto> toListDto(List<Motorista> motoristas){
        List<MotoristaResponseDto> dtos = new ArrayList<>();

        for(Motorista mtr : motoristas){
            dtos.add(toDto(mtr));
        }

        return dtos;
    }
}
