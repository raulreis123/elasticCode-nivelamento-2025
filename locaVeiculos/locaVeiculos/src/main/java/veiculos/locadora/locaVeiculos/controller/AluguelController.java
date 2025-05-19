package veiculos.locadora.locaVeiculos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veiculos.locadora.locaVeiculos.dto.aluguel.AluguelRequestDto;
import veiculos.locadora.locaVeiculos.dto.aluguel.AluguelResponseDto;
import veiculos.locadora.locaVeiculos.service.AluguelService;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    @Autowired
    private AluguelService service;

    @GetMapping
    public ResponseEntity<List<AluguelResponseDto>> listar(){
        return ResponseEntity.status(200).body(service.listar());
    }

    @PostMapping
    public ResponseEntity<AluguelResponseDto> cadastrar(@Valid @RequestBody AluguelRequestDto dto){
        return ResponseEntity.status(201).body(service.cadastrar(dto));
    }
}
