package elasticcode.solutis.entity;

public abstract class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private Float preco;

    public Livro(String titulo, String autor, String editora, Float preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public abstract String toString();
}
