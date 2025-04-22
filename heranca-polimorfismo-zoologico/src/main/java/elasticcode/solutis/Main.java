package elasticcode.solutis;

import elasticcode.solutis.entity.animais.*;

public class Main {
    public static void main(String[] args) {
        Preguica preguica1 = new Preguica("Chimbinha", 30);
        Preguica preguica2 = new Preguica("GT", 12);
        Preguica preguica3 = new Preguica("TR", 21);
        Cavalo cavalo1 = new Cavalo("Thor", 15);
        Cavalo cavalo2 = new Cavalo("RE", 11);
        Cavalo cavalo3 = new Cavalo("Thor", 21);
        Cachorro cachorro1 = new Cachorro("Paçoca", 7);
        Cachorro cachorro2 = new Cachorro("FA", 4);
        Cachorro cachorro3 = new Cachorro("AS", 12);
        Cachorro cachorro4 = new Cachorro("PA", 17);

        Veterinario vet = new Veterinario("Gerson", 35);

        System.out.println(vet.exame(preguica1));
        System.out.println(vet.exame(cavalo1));
        System.out.println(vet.exame(cachorro1));

        Zoologico zoologico = new Zoologico();

        zoologico.addAnimal(preguica1);
        zoologico.addAnimal(preguica2);
        zoologico.addAnimal(preguica3);
        zoologico.addAnimal(cavalo1);
        zoologico.addAnimal(cavalo2);
        zoologico.addAnimal(cavalo3);
        zoologico.addAnimal(cachorro1);
        zoologico.addAnimal(cachorro2);
        zoologico.addAnimal(cachorro3);
        zoologico.addAnimal(cachorro4);

        for (Animal a : zoologico.getAnimals()){
            System.out.println(a);

            if(a.acao().equals("Correndo...")){
                System.out.println("Animal animal correndo.");
            }
        }
    }
}