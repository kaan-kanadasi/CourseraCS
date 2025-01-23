public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int positiony, positionx, count;
        double totalSteps = 0;
    
        for (int i = 0; i < trials; i++) {
            positiony = 0;
            positionx = 0;
            count = 0;

            while (r * r > (positionx * positionx) + (positiony * positiony)) {
                int direction = (int) (Math.random() * 4);

                if (direction == 0) {
                    positionx = positionx - 1;
                } else if (direction == 1) {
                    positionx = positionx + 1;
                } else if (direction == 2) {
                    positiony = positiony - 1;
                } else {
                    positiony = positiony + 1;
                }
                count++;
            }
         totalSteps += count;
        }
        double averageSteps = totalSteps / trials;
        System.out.println("Average number of steps = " + averageSteps);
    }
}