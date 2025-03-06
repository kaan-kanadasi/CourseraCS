package Chapter1.Ch4;
import java.util.Arrays;
// assuming no duplicates

public class ThreeSum {
    public static int threeSum(int[] nums) {
        Arrays.sort(nums); // mergestort -> O(nlogn)
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) { // O(n)
            int lo = i + 1, hi = n - 1;
            while (lo < hi) { // O(n)
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    count++;
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }
}
