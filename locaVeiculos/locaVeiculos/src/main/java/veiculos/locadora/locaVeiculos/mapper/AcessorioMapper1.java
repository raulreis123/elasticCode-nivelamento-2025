package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioRequestDto;
import veiculos.locadora.locaVeiculos.dto.acessorios.AcessorioResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Acessorio;

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
}
