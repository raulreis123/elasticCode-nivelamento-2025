package elasticcode.solutis;

import java.util.Scanner;

public class SwitchCodigo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Insira um código");
        String codigo = leitor.nextLine();

        if(codigo.equals("001")) System.out.println("Parafuso");
        else if(codigo.equals("002")) System.out.println("Porca");
        else if(codigo.equals("003")) System.out.println("Prego");
        else System.out.println("Código inválido!");
    }
}
