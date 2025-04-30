package code.elastic.mercado.mapper;

import code.elastic.mercado.dto.ProdutoAtualizadoDto;
import code.elastic.mercado.dto.ProdutoCadastroDto;
import code.elastic.mercado.dto.ProdutoRespostaDto;
import code.elastic.mercado.entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {
    public static Produto toEntity(ProdutoCadastroDto dto){
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setCategoria(dto.getCategoria());
        produto.setPreco(dto.getPreco());
        produto.setQtdEstoque(dto.getQtdEstoque());
        produto.setDataValidade(dto.getDataValidade());

        return produto;
    }

    public static ProdutoRespostaDto toDto(Produto produto){
        ProdutoRespostaDto dto = new ProdutoRespostaDto();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setCategoria(produto.getCategoria());
        dto.setPreco(produto.getPreco());

        return dto;
    }

    public static List<ProdutoRespostaDto> toListDto(List<Produto> prts){
        List<ProdutoRespostaDto> dtoList = new ArrayList<>();
        for (Produto dto : prts){
            dtoList.add(toDto(dto));
        }

        return dtoList;
    }

    public static Produto toEntityUpdated(Produto prd, ProdutoAtualizadoDto dto){
        prd.setCategoria(dto.getCategoria());
        prd.setPreco(dto.getPreco());
        prd.setDescricao(dto.getDescricao());
        prd.setDataValidade(dto.getDataValidade());

        return prd;
    }
}
