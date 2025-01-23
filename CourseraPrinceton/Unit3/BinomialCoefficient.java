/* 
* Binomial coefficients. Write a program that takes an integer command-line argument n and creates a two-dimensional ragged 
* array a[][] such that a[n][k] contains the probability that you get exactly k heads when you toss a fair coin n times.
* These numbers are known as the binomial distribution: if you multiply each element in row i by 2^n, you get the binomial 
* coefficients—the coefficients of x^k in (x+1)^n—arranged in Pascal’s triangle. To compute them, start with a[n][0] = 0.0 
* for all n and a[1][1] = 1.0, then compute values in successive rows, left to right, with 
* a[n][k] = (a[n-1][k] + a[n-1][k-1]) / 2.0./**           
* @author Kaan Kanadasi
* @since 23 nov 2023
*/

public class BinomialCoefficient {
   public static void main(String[] args) {   
      int n = Integer.parseInt(args[0]);
      int k = Integer.parseInt(args[1]);
      int[][] a = new int[n][k];
      int heads = 0;
      int count = 0;

      for (int i = 0; i < n; i++) {
         int prob = (int)Math.random();
         if(prob == 0) {
            heads++;
         } 
         count++;
      }
      double probHeads = heads/count;

      System.err.println(a + " " + probHeads);

   }
}