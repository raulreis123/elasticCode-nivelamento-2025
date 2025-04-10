package elasticcode.solutis;

import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int num = lt.nextInt();

        for (int i = 2; i < num; i++) {
            boolean isPrimo = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimo = false;
                }
            }
            if(isPrimo){
                System.out.println(i);
            }
        }
    }
}
