/**
  ~/Desktop/loops> java BandMatrix 8 1
  *  *  0  0  0  0  0  0  
  *  *  *  0  0  0  0  0  
  0  *  *  *  0  0  0  0  
  0  0  *  *  *  0  0  0  
  0  0  0  *  *  *  0  0  
  0  0  0  0  *  *  *  0  
  0  0  0  0  0  *  *  *  
  0  0  0  0  0  0  *  * 
 * @author Kaan Kanadasi 
 * @since 22 nov 2023
 */
public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) <= width) { 
                    System.out.print("*  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
    }
}