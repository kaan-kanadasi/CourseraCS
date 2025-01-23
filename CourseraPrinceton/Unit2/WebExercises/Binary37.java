/**
 * Write 1 if n is odd, 0 if n is even. Divide n by 2, throwing away the remainder. Repeat until n = 0 and read the answer 
 * backwards. Use % to determine whether n is even, and use string concatenation to form the answer in reverse order.
 * Solution: 39/121
 * @author Kaan Kanadasi
 * @since 21 nov 2023
 */

 public class Binary37 {
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        String binary = "";
        while (input != 0) {
            if (input % 2 == 1) {
                binary += "1";
            } else {
                binary += "0";
            } 
            input = input/2;
        } 
        System.out.println("Binary: " + binary);
    }
 }