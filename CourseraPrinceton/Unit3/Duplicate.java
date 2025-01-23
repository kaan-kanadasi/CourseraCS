/**
 * Find a duplicate. Given an integer array of length n, with each value between 1 and n, write a code fragment to determine 
 * whether there are any duplicate values. You may not use an extra array 
 * (but you do not need to preserve the contents of the given array.)              
 * @author hepsini ben yazdım hiçbir şeye bakmadan
 * @since 23 nov 2023
 */

 public class Duplicate {
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        int[] ar = new int[n]; // n elementli bir int array yaratır

        for (int i = 0; i < n; i++) { 
            int rand = (int)(Math.random()*n+1); // random integers between 1 and n
            ar[i] += rand; // assigns rand to the elements of the array
        }

        for (int j = 0; j < ar.length; j++) {
            for (int z = 0; z < ar.length; z++) {
                if (ar[j] == ar[z]) { // bu memeory location'a bakar 
                    System.out.println("there are duplicate elements");
                } else {
                    System.out.println("there are no duplicate elements");
                }
            }
        }

    }
}