package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.aluguel.AluguelRequestDto;
import veiculos.locadora.locaVeiculos.dto.aluguel.AluguelResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelMapper {
    public Aluguel toEntity(AluguelRequestDto dto){
        Aluguel aluguel = new Aluguel();

        aluguel.setDataPedido(dto.getDataPedido());
        aluguel.setDataEntrega(dto.getDataEntrega());
        aluguel.setDataDevolucao(dto.getDataDevolucao());
        aluguel.setCarro(dto.getCarro());

        return aluguel;
    }

    public AluguelResponseDto toDto(Aluguel aluguel){
        AluguelResponseDto dto = new AluguelResponseDto();

        dto.setId(aluguel.getId());
        dto.setValorTotal(aluguel.getValorTotal());
        dto.setCarro(aluguel.getCarro());

        return dto;
    }

    public List<AluguelResponseDto> toListDto(List<Aluguel> aluguels){
        List<AluguelResponseDto> listDtos = new ArrayList<>();

        for (Aluguel aluguel : aluguels){
            listDtos.add(toDto(aluguel));
        }

        return listDtos;
    }
}
