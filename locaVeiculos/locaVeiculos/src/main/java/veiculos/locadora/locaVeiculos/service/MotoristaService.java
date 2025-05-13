package veiculos.locadora.locaVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaRequestDto;
import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Motorista;
import veiculos.locadora.locaVeiculos.exceptions.EntidadeNaoEncontradoException;
import veiculos.locadora.locaVeiculos.mapper.MotoristaMapper;
import veiculos.locadora.locaVeiculos.repository.MotoristaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {
    private MotoristaMapper mapperStruct;

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    public MotoristaService(MotoristaMapper mapperStruct) {
        this.mapperStruct = mapperStruct;
    }

    // CREATE
    public MotoristaResponseDto cadastrar(MotoristaRequestDto request){
        Motorista motorista = mapperStruct.toEntity(request);
        MotoristaResponseDto dto = mapperStruct.toDto(repository.save(motorista));
        System.out.println("Cadastro realizado com sucesso");
        return dto;
    }

    // READ
    public List<MotoristaResponseDto> listarTodos(){
        return mapperStruct.toListDto(repository.findAll());
    }

    public MotoristaResponseDto listarPorId(Integer id){
        Optional<Motorista> motorista = repository.findById(id);

        if(motorista.isEmpty()){
            throw new EntidadeNaoEncontradoException("Motorista com id %d não encontrado!".formatted(id));
        }

        return mapperStruct.toDto(motorista.get());
    }

    // UPDATE
    public MotoristaResponseDto atualizar(MotoristaRequestDto request, Integer id){
        if(!repository.existsById(id)){
            throw new EntidadeNaoEncontradoException("Motorista com id %d não encontrado!".formatted(id));
        }

        Motorista motorista = mapperStruct.toEntity(request);
        motorista.setId(id);

        return mapperStruct.toDto(repository.save(motorista));
    }

    // DELETE
    public void deletarPorId(Integer id){
        if(!repository.existsById(id)){
            throw new EntidadeNaoEncontradoException("Motorista com id %d não encontrado!".formatted(id));
        }

        repository.deleteById(id);
    }
}
