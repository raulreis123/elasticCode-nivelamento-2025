package code.elastic.mercado.service;

import code.elastic.mercado.dto.ProdutoAtualizadoDto;
import code.elastic.mercado.dto.ProdutoCadastroDto;
import code.elastic.mercado.dto.ProdutoRespostaDto;
import code.elastic.mercado.entity.Produto;
import code.elastic.mercado.mapper.ProdutoMapper;
import code.elastic.mercado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public List<ProdutoRespostaDto> listar(){
        List<Produto> prts = repository.findAll();
        return ProdutoMapper.toListDto(prts);
    }

    public ProdutoRespostaDto cadastrar(ProdutoCadastroDto dto){
        Produto produto = ProdutoMapper.toEntity(dto);
        return ProdutoMapper.toDto(repository.save(produto));
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }

    public ProdutoRespostaDto atualizar(Integer id, ProdutoAtualizadoDto dto){
        Optional<Produto> produto = repository.findById(id);

        if(produto.isPresent()){
            Produto prdAtualizado = ProdutoMapper.toEntityUpdated(produto.get(), dto);
            prdAtualizado.setId(id);
            repository.save(prdAtualizado);
            return ProdutoMapper.toDto(prdAtualizado);
        }

        return null;
    }
}
