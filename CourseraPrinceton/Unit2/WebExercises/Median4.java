/**
 * takes five integer command-line arguments and prints the median (the third largest one).
 * @author Kaan Kanadasi
 * @since 21 nov 2023
 */
import java.util.Arrays;
public class Median4 {
    public static void main(String[] args) {
    int[] intArray = new int[5];

    /* gereksiz uzun yaptım ilk başta:
        int int1 = Integer.parseInt(args[0]);
        int int2 = Integer.parseInt(args[1]);
        int int3 = Integer.parseInt(args[2]);
        int int4 = Integer.parseInt(args[3]);
        int int5 = Integer.parseInt(args[4]); 
        intArray = {int1, int2, int3, int4, int5};
     */

    for (int i = 0; i < 5; i++) {
        intArray[i] = Integer.parseInt(args[i]);
    }

    Arrays.sort(intArray);
    int median = intArray[2];
    System.out.println("Median: " + median);
    }
}