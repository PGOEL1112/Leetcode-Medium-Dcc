import java.util.Arrays;

public class CatalansNumber {
    // Tabulatiion Method
    public static int CatalanTabulation(int n){
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <=n; i++) {
            for(int j=0; j<i; j++){
                dp[i] += dp[j]* dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    // Memoization Method
    public static int CatalanMemoization(int n,int[] dp){
        if(n==0 || n==1) return 1;

        if(dp[n]!=-1) return dp[n];

        int CatalansNum = 0;
        for (int i = 0; i < n; i++) {
            CatalansNum+= CatalanMemoization(i,dp) * CatalanMemoization(n-i-1,dp);
        }
        return dp[n] = CatalansNum;
    }
    
    // Recursion Method
    public static int CatalanRecursion(int n){
        if(n==0 || n==1) return 1;

        int CatalansNum = 0;
        for (int i = 0; i < n; i++) {
            CatalansNum+= CatalanRecursion(i) * CatalanRecursion(n-i-1);
        }
        return CatalansNum;
    }       
    public static void main(String[] args) {
        int n = 10;
 
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int result = CatalanTabulation(n);
        System.out.print("THE 10th Term of Catalan's Series is (C10) :" + result );
    }
}
