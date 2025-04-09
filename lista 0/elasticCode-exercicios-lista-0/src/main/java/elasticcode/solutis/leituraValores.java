package elasticcode.solutis;

public class leituraValores {
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        System.out.println("Var A: " + a + "    Var B: " + b);
        a = b;
        b = a;
        System.out.printf("%d, %d%n", a, b);
    }
}
