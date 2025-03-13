package Chapter1.Ch4;
import java.util.Arrays;

public class TwoSum {
    public static int twoSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (binarySearch(nums, -nums[i]) > i) {
                count++;
            }
        }
        return count;
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;  
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
