/*
 * .length is a field and not a method, so you don’t add parentheses after length
 * Field is a term used to describe a variable that's a part of a class or structure. Fields represent the data that an object of 
 * that class or structure holds. They define the characteristics or attributes of an object and can have different data types.
 * java'nın ilçindeki gizli bir attribute gibi düşün .length bu attribute'u çağırıyor
*/

/*
 * The number of rows (or height) is the length of the outer array
 * The number of columns (or width) is the length of the inner array
*/

// Looping Through a 2D Array
int[][] array = { {1,2,3},{4,5,6}};
for (int row = 0; row < array.length; row++) {
    for (int col = 0; col < array[0].length; col++) {
        System.out.println( array[row][col] );
    }
}



public static double getAverage(int[][] a) {
    double total = 0;
    int value = 0;
    for (int row = 0; row < a.length; row++) {
        for (int col = 0; col < a[0].length; col++) {
            value = a[row][col];
            total += value;
        }
    }
    return total / (a.length * a[0].length);
}
public static void main(String[] args) {
    int[][] matrix = { {1, 2, 3, 4}, {4, 5, 6, 7}};
    System.out.println(getAverage(matrix));
}



public static int getLargest(int[][] arr) {
    int largest = arr[][];
    int current = 0;
    for(int r = 0; r < arr.length; r++) {
        for(int c = 0; c < arr[0].lenght; c++) {
            current = arr[r][c];
            if(current > largest) 
                largest = current;
        }
    }
    return largest;
}


// linear search yapıyor ve 2 ile bölünebilen elementleri return ediyor
public static int sequentialSearch(int[][] array) { // Array
    for (int col = 0; col < array[0].length; col++) {
        for (int row = 0; row < array.length; row++) {
            if(array[row][col] % 2 == 0) {
                return array[row][col];
            }
        }
    }
    return -1;
}
int[][] array = {{1, 2, 3}, {4, 5, 6}};
for (int col = 0; col < array[0].length; col++) {
    for (int row = 0; row < array.length; row++) {
        System.out.print(array[row][col] + " ");
    }
}
/*
 * 1 4 2 5 3 6
*/



int[][] points = { 
    {11, 12, 13, 14, 15},
    {21, 22, 23, 24, 25},
    {31, 32, 33, 34, 35},
    {41, 42, 43, 44, 45}
};
for (int row = 0; row < points.length; row++) {
    for (int col = points[0].length - 1; col >= row; col--) {
        System.out.print(points[row][col] + " ");
    }
    System.out.println();
}
/*
 * 15, 14, 13, 12, 11
 * 25, 24, 23, 22
 * 35, 34, 33
 * 45, 44
*/