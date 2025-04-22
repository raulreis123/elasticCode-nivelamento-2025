package elasticcode.solutis.entity.animais;

public class Cavalo extends Animal{
    public Cavalo(String nome, Integer idade) {
        super(nome, idade);
    }

    @Override
    public String emitirSom(){
        return "*relinchando*";
    }

    @Override
    public String acao(){
        return "Correndo...";
    }
}
