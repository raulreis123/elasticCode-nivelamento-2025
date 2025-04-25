package elasticcode.solutis.entity;

import java.util.Arrays;

public class Venda {
    private Livro[] livros;
    private static Integer numVendas = 0;
    private final Integer numero;
    private String nomeCliente;
    private Double valor = 0.0;


    public Venda(String nomeCliente, int qtdLivros){
        this.nomeCliente = nomeCliente;
        this.numero = ++numVendas;
        livros = new Livro[qtdLivros];
    }

    public void addLivro(Livro l, int index) {
        if (index >= 0 && index < livros.length) {
            if (livros[index] == null) {
                livros[index] = l;
                valor += l.getPreco();

                if (l instanceof Impresso) {
                    ((Impresso) l).atualizarEstoque();
                }
            } else {
                System.out.println("Já existe um livro nessa posição.");
            }
        } else {
            System.out.println("Índice inválido para adicionar livro.");
        }
    }

    public void listarLivros(){
        for (Livro l : livros) {
            if (l != null) {
                System.out.println("\nLivro: " + l.toString());
            }
        }
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Venda");
        sb.append("livros=").append(Arrays.toString(livros));
        sb.append(", numero=").append(numero);
        sb.append(", nomeCliente='").append(nomeCliente).append('\'');
        sb.append(", valor=").append(valor);
        sb.append('\n');
        return sb.toString();
    }
}
