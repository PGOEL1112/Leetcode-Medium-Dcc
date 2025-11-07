import java.util.HashMap;

public class SumOfNBeautyOfAllSubstrings {

    // Function to calculate beauty of a given substring
    public static int beauty(String sub) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : sub.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;

        for (int val : map.values()) {
            minFreq = Math.min(minFreq, val);
            maxFreq = Math.max(maxFreq, val);
        }

        return maxFreq - minFreq;
    }
    public static int beautySum(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1); 
                count += beauty(sub);                
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        int result = beautySum(s);
        System.out.println("The result is : " + result);
    }
}
