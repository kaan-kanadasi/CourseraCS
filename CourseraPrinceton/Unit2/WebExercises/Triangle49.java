/**
 * takes a command-line argument N and prints an N-by-N triangular pattern 
 * @author not me
 * @since 21 nov 2023
 */
 import java.util.Scanner;
 public class Triangle49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        scanner.close();
    }
 }