package veiculos.locadora.locaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veiculos.locadora.locaVeiculos.dto.FuncionarioRequestDto;
import veiculos.locadora.locaVeiculos.dto.FuncionarioResponseDto;
import veiculos.locadora.locaVeiculos.service.FuncionarioService;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> cadastrar(@RequestBody FuncionarioRequestDto request) {
        return ResponseEntity.status(201).body(service.cadastrar(request));
    }
}
