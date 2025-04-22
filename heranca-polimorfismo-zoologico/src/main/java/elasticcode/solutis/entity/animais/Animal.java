package elasticcode.solutis.entity.animais;

public abstract class Animal {
    protected String nome;
    protected Integer idade;

    public Animal(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public abstract String emitirSom();
    public abstract String acao();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", idade=").append(idade);
        sb.append('}');
        return sb.toString();
    }
}
