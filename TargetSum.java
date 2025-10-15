public class TargetSum {
    static int sum;

    private static int ways(int i, int[] arr, int res, int target, int[][] dp) {
        if(i==arr.length) return (res==target) ? 1 : 0;
        

        if(dp[i][res+sum]!=-1) return dp[i][res+sum];

        int add = ways(i+1,arr,res+arr[i],target,dp);
        int sub = ways(i+1,arr,res-arr[i],target,dp);
        
        return dp[i][res+sum] = add + sub;

    
    }

    private static int findTargetWaysSum(int[] arr, int target) {
        sum =0; 
        int n = arr.length;

        // sum of array
        for(int ele : arr) sum+=ele;

        int[][] dp = new int[n][2*sum+1];

        //filling dp
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }

        return ways(0,arr,0,target,dp);
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        
        System.out.println(findTargetWaysSum(arr,target));

    }
    
    
    
}
