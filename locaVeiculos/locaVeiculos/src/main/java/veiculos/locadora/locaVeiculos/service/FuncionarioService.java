package veiculos.locadora.locaVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veiculos.locadora.locaVeiculos.dto.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.mapper.FuncionarioMapperStruct;
import veiculos.locadora.locaVeiculos.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private FuncionarioMapperStruct mapperStruct;

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    public FuncionarioService(FuncionarioMapperStruct mapperStruct) {
        this.mapperStruct = mapperStruct;
    }

    public FuncionarioResponseDto cadastrar(FuncionarioRequestDto request){
        return mapperStruct.toDto(repository.save(mapperStruct.toEntity(request)));
    }
}
