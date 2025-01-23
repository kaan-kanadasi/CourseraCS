/**
 * takes a command-line argument N and prints a random permutation of the integers 0 through N-1. Also print a  
 * checkerboard visualization of the permutation. As an example, the permutation { 4, 1, 3, 0, 2 } corresponds to:
 % java Shuffle 5, Shuffle 6:           5 0 2 3 1 4
        4 1 3 0 2                       . * . . . .
        * * * Q *                       . . . . * .    
        * Q * * *                       . . * . . . 
        * * * * Q                       . . . * . .    
        * * Q * *                       . . . . . *
        Q * * * *                       * . . . . .                  
 * @author Kaan Kanadasi
 * @since 22 nov 2023
 */

 public class Permutation {
    public static void main(String[] args) {    
        int n = Integer.parseInt(args[0]); // input int n
        int[] firstLine = new int[n]; // decleares int array in length n
        int[] a = new int[n];

        for (int i = 0; i < n; i++) // Math.random() kullanamazdım çünkü o zaman bir değer iki kere yazılabilirdi
            firstLine[i] = i;  // if(n==5) firstLine[i] = {1, 2, 3, 4, 5} olurdu
        
        for (int j = 0; j < n; j++) { // shuffles the array
            int rand = j + (int) (Math.random() * (n-j));
            int temp = firstLine[rand]; // swap random array(temp) with firstLine
            firstLine[rand] = firstLine[j];
            firstLine[j] = temp; // copy temp for firstLine
        }

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " "); // prints for example: 5 0 2 3 1 4
        System.out.println(""); // new row for the rest of the code

        for (int i = 0; i < n; i++) { // columns
            for (int b = 0; b < n; b++) { // rows
                if (firstLine[b] == i) { //örnek: eğer 5 arrayin başındaya (arrayda 0 pozisyonu), 
                    // 6. satıra (i=5 çünkü ilk satır 0) ve ilk pozisyonuna (firstLine[0]'daki gibi) * koy
                    System.out.print("* ");
                } else  {
                    System.out.print(". ");
                }
            }
            System.out.println(); // for the new row
        }
    }
 }