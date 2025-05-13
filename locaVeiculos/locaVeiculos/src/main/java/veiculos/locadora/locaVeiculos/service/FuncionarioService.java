package veiculos.locadora.locaVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.entity.usuario.Funcionario;
import veiculos.locadora.locaVeiculos.exceptions.EntidadeNaoEncontradoException;
import veiculos.locadora.locaVeiculos.mapper.FuncionarioMapper;
import veiculos.locadora.locaVeiculos.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private FuncionarioMapper mapperStruct;

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    public FuncionarioService(FuncionarioMapper mapperStruct) {
        this.mapperStruct = mapperStruct;
    }

    // CREATE
    public FuncionarioResponseDto cadastrar(FuncionarioRequestDto request){
        Funcionario funcionario = mapperStruct.toEntity(request);
        FuncionarioResponseDto dto = mapperStruct.toDto(repository.save(funcionario));
        System.out.println("Cadastro realizado com sucesso");
        return dto;
    }

    // READ
    public List<FuncionarioResponseDto> listarTodos(){
        return mapperStruct.toListDto(repository.findAll());
    }

    public FuncionarioResponseDto listarPorId(Integer id){
        Optional<Funcionario> funcionario = repository.findById(id);

        if(funcionario.isEmpty()){
            throw new EntidadeNaoEncontradoException("Funcionario com id %d não encontrado!".formatted(id));
        }

        return mapperStruct.toDto(funcionario.get());
    }

    // UPDATE
    public FuncionarioResponseDto atualizar(FuncionarioRequestDto request, Integer id){
        if(!repository.existsById(id)){
            throw new EntidadeNaoEncontradoException("Funcionário com id %d não encontrado!".formatted(id));
        }

        Funcionario funcionario = mapperStruct.toEntity(request);
        funcionario.setId(id);

        return mapperStruct.toDto(repository.save(funcionario));
    }

    // DELETE
    public void deletarPorId(Integer id){
        if(!repository.existsById(id)){
            throw new EntidadeNaoEncontradoException("Funcionário com id %d não encontrado!".formatted(id));
        }

        repository.deleteById(id);
    }
}
