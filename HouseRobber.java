public class HouseRobber {
    class Solution {
    public int rob(int[] nums) {
        int m = nums.length;
        if(m==1) return nums[0];
        int[] dp = new int[m];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<=m-1;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[m-1];
    }
}
}
