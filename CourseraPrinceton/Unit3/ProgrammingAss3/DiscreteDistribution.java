/* ~/Desktop/arrays> java DiscreteDistribution 25 1 1 1 1 1 1
5 2 4 4 5 5 4 3 4 3 1 5 2 4 2 6 1 3 6 2 3 2 4 1 4
~/Desktop/arrays> java DiscreteDistribution 25 10 10 10 10 10 50
3 6 6 1 6 6 2 4 6 6 3 6 6 6 6 4 5 6 2 2 6 6 2 6 2
~/Desktop/arrays> java DiscreteDistribution 25 80 20
1 2 1 2 1 1 2 1 1 1 1 1 1 1 1 2 2 2 1 1 1 1 1 1 1  
Tamamı ChatGPT
*/
 public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]); // Number of samples
        int[] weights = new int[args.length - 1]; // Array to store provided weights
    
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Integer.parseInt(args[i + 1]);
        }

        if (weights.length == 1) {
            int index = 1; // Output the only available index
            for (int i = 0; i < m; i++) {
                System.out.print(index + " ");
            }
            System.out.println();
            return;
        }
    
        double totalSum = 0;
        for (int i = 0; i < weights.length; i++) {
            totalSum += weights[i];
        }

        double[] probabilities = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            probabilities[i] = (double) weights[i] / totalSum;
        }

        for (int i = 0; i < m; i++) {
            double randomValue = Math.random(); // Generate a random number between 0 and 1
            double cumulativeProbability = 0;
            int index = 0;
            for (int j = 0; j < probabilities.length; j++) {
                cumulativeProbability += probabilities[j];
                if (randomValue <= cumulativeProbability) {
                    index = j+1;
                    break;
                }
            }
            System.out.print(index + " ");
        }
        System.out.println();
        }
    }
    
