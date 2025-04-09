package elasticcode.solutis;

public class MultiplosDeTres {
    public static void main(String[] args){
        for(int i = 1; i <= 100; i++){
            if(i % 3 == 0){
                float num = (float) i / 2;
                System.out.printf("Divisão de %d: %f", i, num);
            }
        }
    }
}
