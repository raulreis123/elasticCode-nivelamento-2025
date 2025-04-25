package elasticcode.solutis.entity;

public class Impresso extends Livro{
    private Float frete; // frete cobrado para entrega do livro
    private Integer estoque;

    public Impresso(String titulo, String autor, String editora, Float preco, Float frete, Integer estoque) {
        super(titulo, autor, editora, preco);
        this.frete = frete;
        this.estoque = estoque;
    }

    public void atualizarEstoque(){
        if (estoque > 0) {
            this.estoque--;
        } else {
            System.out.println("Estoque insuficiente para o livro: " + getTitulo());
        }
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Float getFrete() {
        return frete;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Impresso{");
        sb.append("titulo=").append(super.getTitulo()).append("\n");
        sb.append("autor=").append(super.getAutor()).append("\n");
        sb.append("editora=").append(super.getEditora()).append("\n");
        sb.append("preco=").append(super.getPreco()).append("\n");
        sb.append("frete=").append(frete);
        sb.append(", estoque=").append(estoque);
        sb.append('}');
        return sb.toString();
    }
}
