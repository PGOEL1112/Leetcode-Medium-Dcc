public class UniqueBst {
    class Solution {
    public int numTrees(int n) {
        int[]dp = new int[n+1];
        if(n<=1) return 1;
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i =3 ; i<=n ;i++){
            for(int j=1; j<=i ;j++){
                dp[i]+=(dp[j-1]*dp[i-j]);
            }
        }
        return dp[n];

        
    }
}
}
