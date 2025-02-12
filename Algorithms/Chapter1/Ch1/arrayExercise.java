package Chapter1.Ch1;
import java.lang.Math;

public class arrayExercise {
    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        boolean[][] test = new boolean[i][j];

        for(int n = 0; n < i; n++) {
            for(int m = 0; m < j; n++) {
                if(areRelativelyPrime(n,m)) {
                    test[n][m] = true;
                }
            }
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); 
    }
        
    static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    } 
}
