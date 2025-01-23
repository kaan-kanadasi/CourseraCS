public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int positiony = 0;
        int positionx = 0;
        int count = 0;
    
        System.out.println("(" + positionx + ", " + positiony + ")");
        while (r * r > (positionx * positionx) + (positiony * positiony)) {
            int direction = (int) (Math.random() * 4);

            if (direction == 0) {
                positionx = positionx-1;
            } else if (direction == 1) {
                positionx = positionx+1;
            } else if (direction == 2) {
                positiony = positiony-1;
            } else {
                positiony = positiony+1;
            }
            
            System.out.println("(" + positionx + "," + positiony + ")");
            count++;
        }
        System.out.println("steps = " + count);
    }
}