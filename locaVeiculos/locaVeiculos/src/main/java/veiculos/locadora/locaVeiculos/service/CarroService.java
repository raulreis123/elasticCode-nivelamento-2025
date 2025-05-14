package veiculos.locadora.locaVeiculos.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veiculos.locadora.locaVeiculos.dto.carro.CarroRequestDto;
import veiculos.locadora.locaVeiculos.dto.carro.CarroResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.*;
import veiculos.locadora.locaVeiculos.mapper.AcessorioMapper;
import veiculos.locadora.locaVeiculos.mapper.CarroMapper;
import veiculos.locadora.locaVeiculos.mapper.FabricanteMapper;
import veiculos.locadora.locaVeiculos.mapper.ModeloCarroMapper;
import veiculos.locadora.locaVeiculos.repository.AcessorioRepository;
import veiculos.locadora.locaVeiculos.repository.CarroRepository;
import veiculos.locadora.locaVeiculos.repository.FabricanteRepository;
import veiculos.locadora.locaVeiculos.repository.ModeloCarroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private final CarroMapper mapperStruct;
    private final FabricanteMapper fabricanteMapper;
    private final ModeloCarroMapper modeloCarroMapper;
    private final AcessorioMapper accessorioMapper;
    private final CarroRepository carroRepository;
    private final FabricanteRepository fabricanteRepository;
    private final ModeloCarroRepository modeloCarroRepository;
    private final AcessorioRepository acessorioRepository;
    private final AcessorioMapper acessorioMapper;

    @Autowired
    public CarroService(
            CarroMapper mapperStruct,
            FabricanteMapper fabricanteMapper,
            ModeloCarroMapper modeloCarroMapper,
            AcessorioMapper accessorioMapper,
            CarroRepository carroRepository,
            FabricanteRepository fabricanteRepository,
            ModeloCarroRepository modeloCarroRepository,
            AcessorioRepository acessorioRepository,
            AcessorioMapper acessorioMapper) {
        this.mapperStruct = mapperStruct;
        this.fabricanteMapper = fabricanteMapper;
        this.modeloCarroMapper = modeloCarroMapper;
        this.accessorioMapper = accessorioMapper;
        this.carroRepository = carroRepository;
        this.fabricanteRepository = fabricanteRepository;
        this.modeloCarroRepository = modeloCarroRepository;
        this.acessorioRepository = acessorioRepository;
        this.acessorioMapper = acessorioMapper;
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
        return carroRepository.findAll()
                .stream()
                .map(mapperStruct::toDto)
                .collect(Collectors.toList());
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
