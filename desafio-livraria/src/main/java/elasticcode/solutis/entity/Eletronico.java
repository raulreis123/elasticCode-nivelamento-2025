package elasticcode.solutis.entity;

public class Eletronico extends Livro{
    private Integer tamanho;

    public Eletronico(String titulo, String autor, String editora, Float preco, Integer tamanho) {
        super(titulo, autor, editora, preco);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Eletronico{\n" +
                "titulo=" + getTitulo() + "\n" +
                "autor=" + getAutor() + "\n" +
                "editora=" + getEditora() + "\n" +
                "preco=" + getPreco() + "\n" +
                "tamanho=" + tamanho + "\n" +
                "}";
    }
}
