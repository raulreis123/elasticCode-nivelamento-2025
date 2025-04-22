package elasticcode.solutis.entity.animais;

public class Veterinario {
    private String nome;
    private Integer idade;

    public Veterinario(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String exame(Animal animal){
        return  "Examinando o animal: " + animal + "\nSom do animal: " + animal.emitirSom() + "\n\n";
    }
}
