package veiculos.locadora.locaVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veiculos.locadora.locaVeiculos.dto.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.mapper.FuncionarioMapper;
import veiculos.locadora.locaVeiculos.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioMapper mapper = new FuncionarioMapper();
    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioResponseDto cadastrar(FuncionarioRequestDto request){
        return mapper.toDto(repository.save(mapper.toEntity(request)));
    }
}
