package veiculos.locadora.locaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.funcionario.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.service.FuncionarioService;

import java.util.List;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    FuncionarioService service;
    // MÉTODOS CREATE
    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> cadastrar(@RequestBody FuncionarioRequestDto request) {
        return ResponseEntity.status(201).body(service.cadastrar(request));
    }


    // MÉTODOS READ
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listarTodos(){
        return ResponseEntity.status(200).body(service.listarTodos());
    }

    // MÉTODOS UPDATE
    @PostMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> atualizar(
            @RequestBody FuncionarioRequestDto request,
            @PathVariable Integer id
    ){
        return ResponseEntity.status(200).body(service.atualizar(request, id));
    }

    // MÉTODOS DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletarPorId(id);
        return ResponseEntity.status(204).build();
    }
}
