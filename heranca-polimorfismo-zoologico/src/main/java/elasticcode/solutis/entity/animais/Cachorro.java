package elasticcode.solutis.entity.animais;

public class Cachorro extends Animal{
    public Cachorro(String nome, Integer idade) {
        super(nome, idade);
    }

    @Override
    public String emitirSom(){
        return "*Latido*";
    }

    @Override
    public String acao(){
        return "Correndo...";
    }
}
