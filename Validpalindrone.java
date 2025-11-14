public class Validpalindrone {
    public static boolean isPalindrome(String s) {
       StringBuilder sb = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
       StringBuilder sbNew = new StringBuilder(sb).reverse();
       return sb.toString().equals(sbNew.toString());
    }
 public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    boolean result = isPalindrome(s);
    System.out.print(result);
 }   
}
