package elasticcode.solutis;

import java.util.Scanner;

public class LeituraComDoWhile {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int num = 0;
        int soma = 0;

        do {
            System.out.println("Número: ");
            int numLido = leitor.nextInt();
            soma += numLido;
            num++;
        } while (num <= 50);

        System.out.println("Média artimética: " + soma / 50);
    }
}
