package code.elastic.mercado.controller;

import code.elastic.mercado.dto.ProdutoAtualizadoDto;
import code.elastic.mercado.dto.ProdutoCadastroDto;
import code.elastic.mercado.dto.ProdutoRespostaDto;
import code.elastic.mercado.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDto>> listar(){
        return ResponseEntity.status(200).body(service.listar());
    }

    @PostMapping
    public ResponseEntity<ProdutoRespostaDto> cadastrar(@RequestBody @Valid ProdutoCadastroDto dto){
        return ResponseEntity.status(201).body(service.cadastrar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDto> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid ProdutoAtualizadoDto dto
    ){
        return ResponseEntity.status(200).body(service.atualizar(id, dto));
    }
}
