import java.util.*;
class MaximumValue{
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return process(s, 'a', 'b', x, y);
        } else {
            return process(s, 'b', 'a', y, x);
        }
    }

    private int process(String s, char first, char second, int firstScore, int secondScore) {
        Stack<Character> stack1 = new Stack<>();
        int score = 0;

        // First pass: remove most valuable substring
        for (char c : s.toCharArray()) {
            if (!stack1.isEmpty() && stack1.peek() == first && c == second) {
                stack1.pop();
                score += firstScore;
            } else {
                stack1.push(c);
            }
        }

        // Second pass: remove remaining less valuable substring
        Stack<Character> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            char c = stack1.pop();
            if (!stack2.isEmpty() && c == second && stack2.peek() == first) {
                stack2.pop();
                score += secondScore;
            } else {
                stack2.push(c);
            }
        }

        return score;
    }
}
