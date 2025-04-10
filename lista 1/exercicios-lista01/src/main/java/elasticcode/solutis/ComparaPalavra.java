package elasticcode.solutis;

import java.util.Scanner;

public class ComparaPalavra {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        System.out.println("Palavra 1: ");
        String pl1 = lt.nextLine();
        System.out.println("Palavra 2: ");
        String pl2 = lt.nextLine();

        if(pl1.charAt(0) < pl2.charAt(0)) System.out.printf("\n Ordem \n %s\n %s %n", pl1, pl2);
        else System.out.printf("\n\n %s\n %s %n", pl2, pl1);
        if(pl1.length() > pl2.length()) System.out.println("A palavra %s é maior %n".formatted(pl1));
        else System.out.println("\nA palavra %s é maior %n".formatted(pl2));

    }
}
