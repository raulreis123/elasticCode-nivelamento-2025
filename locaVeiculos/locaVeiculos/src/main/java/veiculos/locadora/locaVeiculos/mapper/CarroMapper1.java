package veiculos.locadora.locaVeiculos.mapper;

import veiculos.locadora.locaVeiculos.dto.carro.CarroRequestDto;
import veiculos.locadora.locaVeiculos.dto.carro.CarroResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroMapper1 {
    ModeloCarroMapper1 mapperModel = new ModeloCarroMapper1();
    AcessorioMapper1 mapperAcess = new AcessorioMapper1();


    public Carro toEntity(CarroRequestDto dto){
        Carro carro = new Carro();

        carro.setPlaca(dto.getPlaca());
        carro.setChassi(dto.getChassi());
        carro.setCor(dto.getCor());
        carro.setValorDiaria(dto.getValorDiaria());
        carro.setModelo(mapperModel.toEntity(dto.getModelo()));
        carro.setAcessorios(mapperAcess.toListEntity(dto.getAcessorios()));

        return carro;
    }

    public CarroResponseDto toDto(Carro carro){
        CarroResponseDto dto = new CarroResponseDto();

        dto.setValorDiaria(carro.getValorDiaria());
        dto.setModelo(mapperModel.toDto(carro.getModelo()));
        dto.setAcessorios(dto.getAcessorios());

        return dto;
    }

    public List<CarroResponseDto> toListDto(List<Carro> carros){
        List<CarroResponseDto> dtos = new ArrayList<>();

        for(Carro car : carros){
            dtos.add(toDto(car));
        }

        return dtos;
    }
}
