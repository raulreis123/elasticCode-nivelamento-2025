package elasticcode.solutis;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        String pl = lt.nextLine();
        System.out.println(Palindromo.isPld(pl));
    }

    public static boolean isPld(String pl){
        String plR = pl.toLowerCase().replace("\\s", "");
        for(int i = 0; i < pl.length(); i++){
            if(plR.charAt(i) != plR.charAt(plR.length() - i - 1)) return false;
        }
        return true;
    }
}

