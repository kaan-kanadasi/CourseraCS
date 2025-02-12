/*
 * Write a Interval1D client that takes an int value n as the command line argument, reads n intervals  
 * (each defined by a pair of double values) from standart input and prints all pairs that intersect
*/
package Chapter1.Ch2;
import java.util.Scanner;
import java.util.ArrayList;

public class Interval1D {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[][] arr = new double[n][2];
        ArrayList<ArrayList<Double>> intersects = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            arr[i][0] = scan.nextDouble();
            arr[i][1] = scan.nextDouble();
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if((arr[j][0] < arr[i][1]) && arr[i][0] < arr[j][1]) {
                    ArrayList<Double> intersectingPair = new ArrayList<>();
                    intersectingPair.add(arr[i][0]);
                    intersectingPair.add(arr[i][1]);
                    intersectingPair.add(arr[j][0]);
                    intersectingPair.add(arr[j][1]);
                    intersects.add(intersectingPair);
                }
            }
        }
        if (intersects.isEmpty()) {
            System.out.println("No intersecting intervals.");
        } else {
            for (ArrayList<Double> pair : intersects) 
                System.out.println(pair);
        }
        scan.close();
    } 
}

