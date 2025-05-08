package br.com.solutis.api_springboot_junit.mapper;

import br.com.solutis.api_springboot_junit.dto.TarefaRequestDto;
import br.com.solutis.api_springboot_junit.dto.TarefaResponseDto;
import br.com.solutis.api_springboot_junit.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TarefaMapper {
    public Tarefa toEntity(TarefaRequestDto dto){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitle(dto.getTitle());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());

        return tarefa;
    }

    public TarefaResponseDto toDto(Tarefa tarefa){
        return new TarefaResponseDto(tarefa.getId(), tarefa.getTitle(), tarefa.getDescricao(), tarefa.getStatus().toString());
    }

    public List<TarefaResponseDto> toListDto(List<Tarefa> tarefas){
        return tarefas.stream().
                map(tarefa -> new TarefaResponseDto(tarefa.getId(), tarefa.getTitle(), tarefa.getDescricao(), tarefa.getStatus().toString()))
                .collect(Collectors.toList());
    }
}
