/**
 * takes four double command-line arguments x1, y1, x2, and y2 —the latitude and longitude (in degrees) of 
 * two points on the surface of the earth—and prints the great-circle distance (in kilometers) between them
 * @author Kaan Kanadasi
 * @since 20 nov 2023
 */

 public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double r = 6371.0;

        // converting values to radians to be used in trignonometric functions
        x1 = Math.toRadians(x1); 
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);

        double inside = Math.pow(Math.sin((x2-x1)/2), 2) + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);
        double distance = 2 * r * Math.asin(Math.sqrt(inside));
        System.out.println(distance + " kilometers");
    }
 }

