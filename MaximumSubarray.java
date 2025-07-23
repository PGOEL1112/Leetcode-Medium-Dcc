public class MaximumSubarray {
    class Solution {
    public int maxSubArray(int[] nums) {
        int currsum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i =0 ; i< nums.length ; i++){
            currsum+=nums[i];
            if(currsum> maxSum) maxSum = currsum;
            if(currsum<0) currsum=0;
        }
        return maxSum;

    }
}
}
