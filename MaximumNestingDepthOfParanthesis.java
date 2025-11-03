public class MaximumNestingDepthOfParanthesis {
    public static int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (ch == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
        
    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";
        int result = maxDepth(s);
        System.out.println(result);

    }
}
