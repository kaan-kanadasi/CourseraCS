/*
 * Write a Point2D client that takes an integer value n from the command line, generates n random  
 * points in the unit square and computes the distance seperating the closest pair of points
*/
import java.lang.Math;
public class Point2D {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[][] arr = new double[n][2];
        double min_distance = Double.MAX_VALUE;
        double distance;
        double dx;
        double dy;

        for(int i = 0; i < n; i++) {
            arr[i][0] = Math.random();
            arr[i][1] = Math.random(); 
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                dx = arr[j][0] - arr[i][0];
                dy = arr[j][1] - arr[i][1];
                distance = Math.sqrt(dx*dx + dy*dy);
                if(distance < min_distance) {
                    min_distance = distance;
                }
            }
        }
        System.err.println("Minimum distance: " + min_distance);
    }
}