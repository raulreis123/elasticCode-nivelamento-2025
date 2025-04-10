package elasticcode.solutis;

import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        System.out.println("Área do circulo: ");
        double r = lt.nextDouble();
        double area = Math.PI * 2 * r * r;

        System.out.printf("%.2f%n", area);
    }
}
