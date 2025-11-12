public class OnesAndZeroes {
    public static int helper(String[] strs, int m , int n , int indx){
        if(indx>=strs.length()) return 0;
        
        int zeroes = 0;
        int ones = 0;
        for (char c : strs[indx].toCharArray()) {
            if (c == '0') zeroes++;
            else ones++;
        }

        int notPick = helper(strs,zeroes,ones,indx+1);
        int pick = 0;
        if(m>=zeroes && n>=ones){
            pick = 1 + helper(strs,m-zeroes,n-ones,indx+1);
        }

        return Math.max(pick, notPick);       
    }

    public static int findMaxForm(String[] strs, int m , int n){
        int result = helper(strs, m, n, 0);

        return result;       
    }
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n =3;

        int result = findMaxForm(strs,m, n);
        System.out.print("The result is : " + result);
    }
}
