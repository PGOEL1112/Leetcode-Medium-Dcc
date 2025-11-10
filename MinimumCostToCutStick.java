import java.sql.Array;
import java.util.Arrays;

public class MinimumCostToCutStick {


    // Recursion + Memoization
    public static int costMin2(int i, int j, int[] cutsNew, int[][] dp ){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int len = cutsNew[j+1] - cutsNew[i-1];
            int totalCost = costMin2(i, k - 1, cutsNew, dp) + costMin2(k + 1, j, cutsNew, dp) + len;
            minCost = Math.min(totalCost,minCost);
        }
        return dp[i][j] = minCost;
    }
    public static int minCost2(int n, int[] cuts){
        int m = cuts.length;

        int[] cutsNew = new int[m+2];
        cutsNew[0] = 0;
        
        int len = cutsNew.length;
        for (int i = 0 ; i < cuts.length; i++) {
            cutsNew[i+1] = cuts[i];
        }

        cutsNew[len-1] = n;
        Arrays.sort(cutsNew);

        int[][] dp = new int[len][len];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        return costMin2(1,len-2,cutsNew,dp);

    }


    // Recursion method 
    public static int costMin1(int i, int j, int[] cutsNew){
        if(i>j) return 0;
        int minCost = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int len = cutsNew[j+1] - cutsNew[i-1];
            int totalCost = costMin1(i,k-1,cutsNew) + costMin1(k+1,j,cutsNew) + len;
            minCost = Math.min(totalCost,minCost);
        }
        return minCost;
    }
    public static int minCost1(int n, int[] cuts){
        int m = cuts.length;

        int[] cutsNew = new int[m+2];
        cutsNew[0] = 0;

        int len = cutsNew.length;
        for (int i = 0 ; i < cuts.length; i++) {
            cutsNew[i+1] = cuts[i];
        }

        cutsNew[len-1] = n;
        Arrays.sort(cutsNew);
        return costMin1(1,len-2,cutsNew);

    }

    // Tabulation method 
    public static int minCost(int n, int[] cuts){
        int m = cuts.length;

        int[] cutsNew = new int[m+2];
        cutsNew[0] = 0;

        int len = cutsNew.length;
        for (int i = 0 ; i < cuts.length; i++) {
            cutsNew[i+1] = cuts[i];
        }

        cutsNew[len-1] = n;
        Arrays.sort(cutsNew);

        int[][] dp = new int[m+2][m+2];
        for (int i = m; i > 0; i--) {
            for (int j = i; j <= m; j++) {
                if(i>j){
                    dp[i][j] =0;
                    continue;
                }
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int x = cutsNew[j+1] - cutsNew[i-1];
                    int totalCost = dp[i][k-1] + dp[k+1][j] + x;
                    minCost = Math.min(minCost, totalCost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][m];
    }
 public static void main(String[] args) {
    int[] cuts = {5,6,1,4,2};
    int n = 9;
    // int result = minCost2(n,cuts);
    // System.out.print("The resultant array is : " + result);

    int result = minCost(n,cuts);
    System.out.print("The resultant array is : " + result);


 }   
}
