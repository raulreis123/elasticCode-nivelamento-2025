package veiculos.locadora.locaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaRequestDto;
import veiculos.locadora.locaVeiculos.dto.motorista.MotoristaResponseDto;
import veiculos.locadora.locaVeiculos.service.MotoristaService;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaService service;

    // CREATE
    @PostMapping
    public ResponseEntity<MotoristaResponseDto> cadastrar(@RequestBody MotoristaRequestDto request){
        return ResponseEntity.status(201).body(service.cadastrar(request));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<MotoristaResponseDto>> ListarTodos(){
        return ResponseEntity.status(200).body(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaResponseDto> listarPorId(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.listarPorId(id));
    }

    // UPDATE
    @PostMapping("/{id}")
    public ResponseEntity<MotoristaResponseDto> atualizar(
            @RequestBody MotoristaRequestDto request,
            @PathVariable Integer id
    ){
        return ResponseEntity.status(200).body(service.atualizar(request, id));
    }
}
