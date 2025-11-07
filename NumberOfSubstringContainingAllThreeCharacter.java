import java.util.HashMap;

public class NumberOfSubstringContainingAllThreeCharacter {
    public static boolean goodString(String s){
        return (s.contains("a") && s.contains("b") && s.contains("c"));
    }
    public static int numberOfSubstrings(String s){
        // Method 1 : Using only sliding Window
    //     int i = 0, j=0;
    //     int count = 0;
    //      while (j < s.length()) {
    //         // expand the window by increasing i
    //         while (i < s.length()) {
    //             String sub = s.substring(j, i + 1);
    //             if (goodString(sub)) {
    //                 count += s.length() - i;
    //                 break;
    //             }
    //             i++;
    //         }
    //         j++;
    //         i = j;
    //      }

    //     return count;

        // Method 2 : Uisng Sliding Window and HashMap Approach 
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // When window has all 3 chars
            while (map.size() == 3) {
                // All substrings from this left to end are valid
                count += s.length() - right;

                // Shrink window
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            right++;
        }

        return count;
    }
    public static void main(String[] args) {
        String s ="aabcb";
        int result = numberOfSubstrings(s);
        System.out.println();
        System.out.print("The result is : " + result);
    }
}
