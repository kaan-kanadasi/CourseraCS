/**
 * Write a code fragment to multiply two rectangular matrices that are not necessarily square. 
 * Note: For the dot product to be well defined, the number of columns in the first matrix must be equal to the 
 * number of rows in the second matrix. Print an error message if the dimensions do not satisfy this condition.                
 * @author Kaan Kanadasi
 * @since 23 nov 2023
 */

 public class MultiplyMatrix {
    public static void main(String[] args) {   
        int n = 3;
        int p = 3;
        int m = 3;
        int[][] result = new int[n][p];
        
        int[][] a = new int[n][m] ;
        int[][] b = new int[m][n] ;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            } 
        }
        
    }
}