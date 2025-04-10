package elasticcode.solutis;

import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {
        String[] diasSemana = new String[7];
        diasSemana[0] = "domingo";
        diasSemana[1] = "segunda";
        diasSemana[2] = "terça";
        diasSemana[3] = "quarta";
        diasSemana[4] = "quinta";
        diasSemana[5] = "segunda";
        diasSemana[6] = "sabado";

        Scanner lt = new Scanner(System.in);
        System.out.println("Digite um numero de 1 a 7: ");
        int num = lt.nextInt();

        System.out.println("Dia da semana: " + diasSemana[num - 1]);
    }
}
