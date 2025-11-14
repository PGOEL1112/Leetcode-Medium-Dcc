public class ValidPalindroneII {
    public static boolean checkPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sbReverse = new StringBuilder(sb).reverse();
        return sb.toString().equals(sbReverse.toString());
    }

    public static boolean checkPalindromeValid(String s , int left, int right, boolean deleted){
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }

            else{
                if(deleted) return false;
                return checkPalindromeValid(s,left+1,right,true) || checkPalindromeValid(s, left, right-1,true);
            }
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        int n = s.length();
        if(checkPalindrome(s)) return true;
        else return checkPalindromeValid(s,0,n-1,false);
    }
    public static void main(String[] args) {
        String s = "aba";
        boolean ans = validPalindrome(s);
        System.out.println(ans);
    }
}
