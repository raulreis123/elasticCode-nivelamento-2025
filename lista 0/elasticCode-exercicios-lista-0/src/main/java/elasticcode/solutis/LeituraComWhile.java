package elasticcode.solutis;

import java.util.Scanner;

public class LeituraComWhile {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int num = 0;
        int soma = 0;

        while (num <= 50){
            System.out.println("Número: ");
            int numLido = leitor.nextInt();
            soma += numLido;
            num++;
        }

        System.out.println("Média artimética: " + soma / 50);
    }
}
