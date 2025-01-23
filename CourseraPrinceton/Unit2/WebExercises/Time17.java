public class Time17 {
    public static void main(String[] args) {
        for(int hour = 0; hour < 24; hour++) {
            if (hour == 0) {
                System.out.println("12 midnight");
            } else if (hour < 12) {
                System.out.println(hour + " am");
            } else if (hour == 12) {
                System.out.println("12 noon");
            } else { 
                System.out.println((hour - 12) + " pm");
            }
        }
    }
}