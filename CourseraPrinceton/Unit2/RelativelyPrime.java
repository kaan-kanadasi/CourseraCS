/**
* take an integer command-line argument n and prints an n-by-n table such that there is an "*" 
* in row i and column j if the gcd of i and j is 1 and a space in that position otherwise.
* @author collaboration
* @since 21 nov 2023
*/

public class RelativelyPrime {
    private static int greatestCommonDivisor(int a, int b) { // int method 
        while (b != 0) {
            if (a > b) { a = a - b; } 
            else { b = b - a; }
        }
        return a; 
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // int input

        for(int i=0; i<n; i++) { 
            for(int j=0; j<n; j++) { 
                if (greatestCommonDivisor(i, j) == 1) { 
                    System.out.print("* ");
                } else {
                    System.out.print("  "); 
                }
            }
            System.out.println(); // new line for the new row
        }
    }
}