package elasticcode.solutis;

import java.util.Scanner;

public class ContagemCaractere {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        System.out.println("Escreva uma palavra para contagem: ");
        String pl = lt.nextLine().toLowerCase();

        int espc = 0;
        int vg = 0;
        int cons = 0;
        int especial = 0;

        for (int i = 0; i < pl.length(); i++){
            char letra = pl.charAt(i);

            if(Character.isAlphabetic(letra)){
                if(Character.isSpaceChar(letra)) espc++;
                else if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') vg++;
                else cons++;
            } else especial++;
        }

        System.out.printf("A palavra possui: %d espaços, %d vogais, %d consoantes e %d especiais.%n", espc, vg, cons, especial);
    }
}

