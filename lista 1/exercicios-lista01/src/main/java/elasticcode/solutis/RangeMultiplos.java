package elasticcode.solutis;

public class RangeMultiplos {
    public static void main(String[] args) {
        int prdInt = 1;
        float prdFloat = 1.0f;

        for (int i = 15; i <= 30; i++) {
            if (i % 2 != 0) {
                prdInt *= i;
                prdFloat *= i;
            }
        }

        System.out.println("Produto int: " + prdInt);
        System.out.println("Produto float: " + prdFloat);
    }
}
