import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int sum = 0, maxSum = 0;

        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                set.add(nums[right]);
                sum += nums[right];
                maxSum = Math.max(maxSum, sum);
                right++;
            } else {
                // remove nums[left] until nums[right] becomes unique
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
