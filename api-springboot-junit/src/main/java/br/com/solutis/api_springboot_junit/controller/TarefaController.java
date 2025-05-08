package br.com.solutis.api_springboot_junit.controller;

import br.com.solutis.api_springboot_junit.dto.TarefaRequestDto;
import br.com.solutis.api_springboot_junit.dto.TarefaResponseDto;
import br.com.solutis.api_springboot_junit.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDto> cadastrar(@Valid @RequestBody TarefaRequestDto dto){
        return ResponseEntity.status(201).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listar(){
        return ResponseEntity.status(200).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> atualizar(@Valid @RequestBody TarefaRequestDto dto, @PathVariable Integer id){
        return ResponseEntity.status(200).body(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }
}
