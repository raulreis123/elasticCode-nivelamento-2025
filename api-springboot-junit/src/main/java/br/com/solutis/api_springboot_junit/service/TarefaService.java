package br.com.solutis.api_springboot_junit.service;

import br.com.solutis.api_springboot_junit.dto.TarefaRequestDto;
import br.com.solutis.api_springboot_junit.dto.TarefaResponseDto;
import br.com.solutis.api_springboot_junit.exceptions.EntidadeNaoEncontradaException;
import br.com.solutis.api_springboot_junit.mapper.TarefaMapper;
import br.com.solutis.api_springboot_junit.model.Status;
import br.com.solutis.api_springboot_junit.model.Tarefa;
import br.com.solutis.api_springboot_junit.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repository;
    private final TarefaMapper mapper;

    public TarefaService(TarefaRepository repository, TarefaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public TarefaResponseDto cadastrar(TarefaRequestDto dto){
        Tarefa tarefa = mapper.toEntity(dto);
        return mapper.toDto(repository.save(tarefa));
    }

    public List<TarefaResponseDto> listar(){
        return mapper.toListDto(repository.findAll());
    }

    public TarefaResponseDto buscarPorId(Integer id){
        return mapper.toDto(repository.findById(id)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Id não encontrado")));
    }

    public TarefaResponseDto atualizar(Integer id, TarefaRequestDto dto){
        Tarefa tarefa = mapper.toEntity(dto);
        tarefa.setId(id);

        return mapper.toDto(repository.save(tarefa));
    }

    public void deletar(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else{
            throw new EntidadeNaoEncontradaException("Usuário com id não encontrado!");
        }
    }
}
