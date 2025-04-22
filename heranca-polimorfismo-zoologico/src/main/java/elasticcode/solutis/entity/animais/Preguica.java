package elasticcode.solutis.entity.animais;

public class Preguica extends Animal{
    public Preguica(String nome, Integer idade) {
        super(nome, idade);
    }

    @Override
    public String emitirSom(){
        return "*Grito estridente*";
    }

    @Override
    public String acao(){
        return "Subindo na árvore...";
    }
}
