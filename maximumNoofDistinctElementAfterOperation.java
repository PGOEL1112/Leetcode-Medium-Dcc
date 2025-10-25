import java.util.*;

public class maximumNoofDistinctElementAfterOperation {
    public static int maxDistinctElements(int[] nums, int k) {
        // Method 1 : Using HashSet and sorting
        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums);

        // Step 2: Try to make each element distinct by adjusting ±k
        for (int num : nums) {
            for (int i = -k; i <= k; i++) {
                int newVal = num + i; // ✅ modify element, not frequency

                if (!set.contains(newVal)) {
                    set.add(newVal); // add new distinct value
                    break;
                }
            }
        }

        return set.size();
    }
       
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4};
        int k = 3;
        int ans = maxDistinctElements(arr,k);
        System.out.println(ans);

    }
    
}
