public class CopyingArray {
    public static void main(String[] args) {    
        /*
        *    - They facilitate storage and manipulation of data
        *    - Efficiency derives from low-level computer hardware organization
        *    - With an index, a program can instantly access a given value
        *    - They enable storage of large amounts of data (values all of the same type)
        *    - Array values are stored in contiguous locations. Çünkü arrayler reference type
        *   Once we create an array, its length is fixed.
        *   if we don't initialize the array to literal values, the default value would depend on the type of the array
        *     - int, byte, short, long: 0
        *     - float, double: 0.0
        *     - boolean: false
        *     - objects[String, Integer, or any other class]: null
        *   int[] a = new int[] { 1, 5, 4, 3, 2 }; - Initialize to literal values
        */ 
        int[] arr; // Declare an array
        arr = new int[3]; // Create an array of a given length

        double[] arr = new double[100]; // intialization 100 elements to 0.0
        double[] arr = { 0.3, 0.6, 0.1 }; // direct initialization

        int[] a = { 1, 5, 4, 3, 2 };

        double[] b = new double[a.length]; // this does not copy an array (it makes b and a refer to the same array).
        b = a; //  Both b and a will point to the same memory location for the array.
        
        // To copy an array, create a new array , then copy all the values
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i]; 
        }

        // Find the maximum of array values - 5
        for (int i = 1; i < c.length; i++) {
            if (c[i] > max) max = c[i]; 
        }

        // after the elements of the arrays of a and c would chnage to since they refer to the same location on the computer memeory
        for (int i = 1; i < b.length; i++)
            b[i] = i; 

        /*
        *    Array index out of bounds - No a[10] (and a[0] unused
        *    double[] a = new double[10];
        *    for (int i = 1; i <= 10; i++)
        *    a[i] = Math.random(); 
        *
        *    Uninitialized array - Never created the array
        *    double[] a;
        *    for (int i = 0; i < 9; i++)
        *    a[i] = Math.random(); 
        *
        *    Undeclared variable - What type of data does a refer to?
        *    a = new double[10];
        *    for (int i = 0; i < 10; i++)
        *    a[i] = Math.random();
        */
    } 
}