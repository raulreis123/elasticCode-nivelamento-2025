package elasticcode.solutis;

import elasticcode.solutis.entity.animais.Animal;

public class Zoologico {
    public Animal[] animals = new Animal[10];
    public int index = 0;

    public void addAnimal(Animal animal){
        if(index <= 9){
            animals[index] = animal;
            index++;
        } else {
            System.out.println("LIMITE DE JAULAS ATINGIDO!");
        }
    }

    public Animal[] getAnimals() {
        return animals;
    }
}
