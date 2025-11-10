import java.util.Stack;

public class MinimumOperationToConvertAllElementTozero {
    public static int minOperations(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int operations = 0;
        for (int ele : nums) {
            while(!st.isEmpty() && st.peek()>ele) st.pop();

            if(ele==0) continue;
            if(st.isEmpty() || st.peek()<ele) {
                st.push(ele);
                operations++;
            }
            
        }
        return operations;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,3,4,2};
        int result = minOperations(nums);
        System.out.println(result);
    }    
}
