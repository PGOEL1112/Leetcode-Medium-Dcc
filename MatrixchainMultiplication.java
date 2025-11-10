public class MatrixchainMultiplication {
    // Method 3 : Tabulation By Dynamic Programming
    public static int mcmTabulationDp(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = n-1; i>=1; i--) {
            for (int j =i; j <n; j++) {
                if(i==j) {
                    dp[i][j] = 0;
                    continue;
                }
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k <j; k++) {
                    int x = arr[i-1] * arr[k] * arr[j];
                    int totalCost = dp[i][k] + dp[k+1][j] + x;
                    minCost = Math.min(minCost, totalCost); 
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n-1];
    }
    // Method 2 : Recursion + Memoization for 1D array
    public static int mcmDp(int i, int j , int[] arr, int[][] dp){
       if(i==j) return 0;
      
       if(dp[i][j]!=-1) return dp[i][j];
       int minCost = Integer.MAX_VALUE;
        for (int k =i; k <j; k++) {
            int x = arr[i] * arr[k+1] * arr[j+1];
            int totalCost = mcmDp(i,k,arr,dp) + mcmDp(k+1,j,arr,dp) + x;
            minCost = Math.min(minCost, totalCost);
        }

        return dp[i][j] = minCost;
    }

    // Method 1 : Recursion for 1D array
    public static int mcm1D(int i, int j , int[] arr){
        if(i==j) return 0;
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = arr[i] * arr[k+1] * arr[j+1];
            int totalCost = mcm1D(i,k,arr) + mcm1D(k+1,j,arr) + x;
            minCost = Math.min(minCost, totalCost);
        }
        return minCost;
    }


    // Method 1 : Recursion for 2D array
    public static int mcm2D(int i, int j, int[][] arr){
        if(i==j) return 0;
        
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = arr[i][0] * arr[k][1] * arr[j][1];
            int totalCost = mcm2D(i,k,arr) + mcm2D(k+1,j,arr) + x;
            minCost = Math.min(minCost, totalCost); 
        }
        return minCost;
    }
    public static void main(String[] args) {
        // For Format in 2D arr
        int[][] arr = {{1,2},{2,3},{3,4},{4,2}};
        int n = arr.length;
        // int result = mcm2D(0,n-1,arr);

        // For Format in 1D arr
        int[] arr2 = {1,2,3,4,2};
        //int result = mcm1D(0,n-2,arr2);


        // Method 2 : By Dynamic Programming ---> Memoization
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        // int result = mcmDp(0,n-1,arr2,dp);
        // System.out.println(result);

        int ans = mcmTabulationDp(arr2);
        System.out.println(ans);
    }
    
}
