package elasticcode.solutis;

public class SomaSete {
    public static void main(String[] args){
        for(int i = 1; i <= 7; i++){
            for (int j = 1; j <= 7; j++){
                if(i + j == 7){
                    System.out.println(String.format("%d + %d = 7", i, j));
                }
            }
        }
    }
}
