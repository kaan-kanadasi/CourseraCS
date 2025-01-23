/**
* takes a command-line argument N and prints a (2N + 1)-by-(2N + 1) diamond 
* @author not me
* @since 21 nov 2023
*/
import java.util.Scanner;

public class Diamond52 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // int n = Integer.parseInt(args[0]);
        
        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                if ( Math.abs(i) + Math.abs(j) <= n) { System.out.print("* "); }
                else { System.out.print(". "); }
            }
            System.out.println();
        }
        scan.close();
    }
 }