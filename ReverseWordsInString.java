import java.util.Arrays;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        String[] result = s.split("\\s+");
        int start = 0;
        int end = result.length-1;
        String temp;
        
        
        while(start<end){
            temp = result[start];
            result[start] = result[end];
            result[end] = temp;

            start++;
            end--;
        }

        return String.join(" ", result).strip();
    }
    public static void main(String[] args) {
        String s = "  a good   example  ";
        String result = reverseWords(s);
        System.out.println(result);

    }
}
