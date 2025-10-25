import java.util.*;

public class MaximumFrequencyofanElementAfterPerformingOperations {

    // Binary search helper
    public int getIndex(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2; // ✅ fixed incorrect formula
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // Calculate possible frequency for a target
    public int maximumFreq(int target, int[] nums, Map<Integer, Integer> map, int k, int numOperations) {
        int left = getIndex(nums, target - k);
        int right = getIndex(nums, target + k + 1);

        int operations = right - left - map.getOrDefault(target, 0);
        return Math.min(numOperations, operations) + map.getOrDefault(target, 0);
    }

    // Main method to find maximum frequency
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            set.add(ele);
            set.add(ele + k);
            set.add(ele - k);
        }

        int ans = 0;
        for (int ele : set) {
            ans = Math.max(ans, maximumFreq(ele, nums, map, k, numOperations));
        }

        return ans;
    }

    // Test driver
    public static void main(String[] args) {
        MaximumFrequencyofanElementAfterPerformingOperations obj = new MaximumFrequencyofanElementAfterPerformingOperations();

        int[] nums = {1, 4, 5};
        int k = 1;
        int numOperations = 2;

        int ans = obj.maxFrequency(nums, k, numOperations);
        System.out.println(ans);
    }
}
