package Chapter1.Ch1;
import java.lang.Math;
import java.util.Arrays;
public class binarySearch {
    public static void main(String[] args) {
        // create a random array
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*11);
        }
        Arrays.sort(arr);

        int i = Integer.parseInt(args[0]);
        System.err.println(binary_sort(i, arr));
    }

    static int binary_sort(int target, int[] arr) {
        // initilizations
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < arr[mid]) hi = mid - 1;
            else if (target > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}