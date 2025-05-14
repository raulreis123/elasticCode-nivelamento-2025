package veiculos.locadora.locaVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veiculos.locadora.locaVeiculos.dto.carro.CarroRequestDto;
import veiculos.locadora.locaVeiculos.dto.carro.CarroResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Categoria;
import veiculos.locadora.locaVeiculos.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<CarroResponseDto> cadastrar(@RequestBody CarroRequestDto request){
        return ResponseEntity.status(201).body(carroService.cadastrar(request));
    }

    @GetMapping
    public ResponseEntity<List<CarroResponseDto>> listarTodos(){
        return ResponseEntity.status(200).body(carroService.listarTodos());
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<CarroResponseDto>> listarPorCategoria(@PathVariable Categoria categoria) {
        return ResponseEntity.ok(carroService.listarPorCategoria(categoria));
    }

    @GetMapping("/acessorios")
    public ResponseEntity<List<CarroResponseDto>> listarPorAcessorios(@RequestParam List<String> acessorios) {
        return ResponseEntity.ok(carroService.listarPorAcessorios(acessorios));
    }

}
