package elasticcode.solutis;

import java.util.Scanner;

public class Abastecimento {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        System.out.println("Insira a quantidade de abastecimentos: ");
        int qtdAbastecimento = lt.nextInt();

        for (int i = 1; i <= qtdAbastecimento; i++){
            System.out.println("%d - Quantidade de litros: ".formatted(i));
            int qtdLitros = lt.nextInt();

            System.out.println("%d - Quantidade de Kilometros: ".formatted(i));
            int qtdKm = lt.nextInt();

            double kmPorLitro = (double) qtdKm / qtdLitros;
            System.out.println("Kilometros por litro: %.2f\n\n".formatted(kmPorLitro));
        }
    }
}
