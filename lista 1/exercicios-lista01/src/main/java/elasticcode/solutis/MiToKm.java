package elasticcode.solutis;

import java.util.Scanner;

public class MiToKm {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        System.out.println("Digite a quantidade de milhas: ");
        int mi = lt.nextInt();

        double km = mi * 1.6;
        System.out.printf("%d milhas equivale a %.2f kilômetros%n", mi, km);
    }
}
