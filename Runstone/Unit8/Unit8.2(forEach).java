String[][] array;
// Nested For-each loops that traverse a 2D String array
for (String[] innerArray : array) { // loop through each element of the outer array
   for (String val : innerArray) {
       System.out.println(val);
   }
}



public class Total {
    public static int getTotalForRow(int row, int[][] a) {
        int total = 0;
        for (int col = 0; col < a[0].length; col++) {
            total += a[row][col];
        }
        return total;
    }

    // Complete the method getTotalForCol below
    public static int getTotalForCol(int col, int[][] a) {
        int total = 0;
        // Add a loop here to total a column col
        for(int row = 0; row < a.length; row++) {
            total += a[row][col];
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}};
        System.out.println(getTotalForRow(0, matrix));
        System.out.println(getTotalForCol(0, matrix));
    }
}



// sadece son array'ijniçindeki arraylerin sadece son elementini almıyor
int[][] arr = { 
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12} 
};
int sum = 0;
for (int[] x : arr) {
    for (int y = 0; y < x.length - 1; y++) { // x.length - 1 önemli detay
         sum += x[y];
    }
}