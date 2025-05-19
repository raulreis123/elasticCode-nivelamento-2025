package veiculos.locadora.locaVeiculos.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veiculos.locadora.locaVeiculos.dto.carro.CarroRequestDto;
import veiculos.locadora.locaVeiculos.dto.carro.CarroResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.*;
import veiculos.locadora.locaVeiculos.mapper.*;
import veiculos.locadora.locaVeiculos.repository.AcessorioRepository;
import veiculos.locadora.locaVeiculos.repository.CarroRepository;
import veiculos.locadora.locaVeiculos.repository.FabricanteRepository;
import veiculos.locadora.locaVeiculos.repository.ModeloCarroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private final CarroMapper1 mapperStruct = new CarroMapper1();
    private final FabricanteMapper1 fabricanteMapper = new FabricanteMapper1();
    private final ModeloCarroMapper1 modeloCarroMapper = new ModeloCarroMapper1();
    private final AcessorioMapper1 acessorioMapper = new AcessorioMapper1();
    private final CarroRepository carroRepository;
    private final FabricanteRepository fabricanteRepository;
    private final ModeloCarroRepository modeloCarroRepository;
    private final AcessorioRepository acessorioRepository;

    @Autowired
    public CarroService(
            CarroRepository carroRepository,
            FabricanteRepository fabricanteRepository,
            ModeloCarroRepository modeloCarroRepository,
            AcessorioRepository acessorioRepository) {
        this.carroRepository = carroRepository;
        this.fabricanteRepository = fabricanteRepository;
        this.modeloCarroRepository = modeloCarroRepository;
        this.acessorioRepository = acessorioRepository;
    }

    public CarroResponseDto cadastrar(@Valid CarroRequestDto requestDto) {

        Fabricante fabricante = fabricanteRepository
                .findByNomeIgnoreCase(requestDto.getModelo().getFabricante().getNome())
                .orElseGet(() -> {
                    Fabricante novo = fabricanteMapper.toEntity(requestDto.getModelo().getFabricante());
                    return fabricanteRepository.save(novo);
                });

        ModeloCarro modelo = modeloCarroMapper.toEntity(requestDto.getModelo());
        modelo.setFabricante(fabricante);
        modelo = modeloCarroRepository.save(modelo);

        List<Acessorio> acessorios = requestDto.getAcessorios()
                .stream()
                .map(acessorio -> acessorioRepository
                        .findByDescricaoIgnoreCase(acessorio.getDescricao())
                        .orElseGet(() -> acessorioRepository.save(acessorioMapper.toEntity(acessorio))))
                .collect(Collectors.toList());

        Carro carro = mapperStruct.toEntity(requestDto);
        carro.setModelo(modelo);
        carro.setAcessorios(acessorios);

        carro = carroRepository.save(carro);

        return mapperStruct.toDto(carro);
    }

    public List<CarroResponseDto> listarTodos() {
        return mapperStruct.toListDto(carroRepository.findAll());
    }

    public List<CarroResponseDto> listarPorCategoria(Categoria categoria) {
        return carroRepository.findByModelo_Categoria(categoria)
                .stream()
                .map(mapperStruct::toDto)
                .collect(Collectors.toList());
    }

    public List<CarroResponseDto> listarPorAcessorios(List<String> descricoes) {
        return carroRepository.findDistinctByAcessorios_DescricaoInIgnoreCase(descricoes)
                .stream()
                .map(mapperStruct::toDto)
                .collect(Collectors.toList());
    }
}
