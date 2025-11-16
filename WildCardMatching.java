public class WildCardMatching {
    public static boolean isMatch(String s, String p){
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];

        //Initialize for both Empty
        dp[0][0] = true;

        //Iniitalizing first colum : means P string is empty
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = false;
        }

        // Initializing first row : means S string is empty
        for (int j = 1; j < m+1; j++) {
            if(p.charAt(j-1)=='*') dp[0][j] = dp[0][j-1];
        }

        //Filing rest of values
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }

                else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.print("The result is : " + isMatch(s,p));
    }
}
