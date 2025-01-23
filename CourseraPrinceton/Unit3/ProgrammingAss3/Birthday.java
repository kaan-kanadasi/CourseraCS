/* tamamı CHATGPT */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] counts = new int[n + 2]; // Count array to track the number of people entering

        for (int t = 0; t < trials; t++) {
            boolean[] birthdays = new boolean[n]; // Array to track birthdays
            int people = 0;

            while (true) {
                int birthday = (int) (Math.random() * n); // Generate a random birthday
                people++;
                if (birthdays[birthday]) { // Check if this birthday already exists
                    break;
                } else {
                    birthdays[birthday] = true; // Mark the birthday as seen
                }
            }
            counts[people]++;
        }

        double totalCount = 0;
        for (int i = 1; i < counts.length; i++) {
            totalCount += counts[i];
            double fraction = totalCount / trials;
            System.out.printf("%d\t%d\t%.5f\n", i, counts[i], fraction);
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
