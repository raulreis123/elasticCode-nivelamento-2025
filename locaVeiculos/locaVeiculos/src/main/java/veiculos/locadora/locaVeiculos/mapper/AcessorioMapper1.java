package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioRequestDto;
import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Acessorio;

import java.util.ArrayList;
import java.util.List;

public class AcessorioMapper1 {
    Acessorio toEntity(AcessorioRequestDto dto){
        Acessorio acessorio = new Acessorio();

        acessorio.setDescricao(dto.getDescricao());
        return acessorio;
    }

    AcessorioResponseDto toDto(Acessorio acessorio){
        AcessorioResponseDto dto = new AcessorioResponseDto();

        dto.setDescricao(acessorio.getDescricao());

        return dto;
    }

    List<Acessorio> toListEntity(List<AcessorioRequestDto> dtos){
        List<Acessorio> acessorios = new ArrayList<>();

        for(AcessorioRequestDto ac : dtos){
            acessorios.add(toEntity(ac));
        }

        return acessorios;
    }
}
