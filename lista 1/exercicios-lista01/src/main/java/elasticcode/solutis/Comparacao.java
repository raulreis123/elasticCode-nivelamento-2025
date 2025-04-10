package elasticcode.solutis;

public class Comparacao {
    public static void main(String[] args) {
        System.out.println(Comparacao.compara(5, 12));
    }

    public static int compara(int a, int b){
        return a > b ? a : b;
    }
}
