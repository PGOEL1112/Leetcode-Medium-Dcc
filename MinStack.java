import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack() {
        st = new Stack<>();
        minst =new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || minst.peek()>=st.peek()){
            minst.push(val);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            int val = st.pop();
            if(minst.peek()==val){
                minst.pop();
            }
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        return st.peek();
    }
    
    public int getMin() {
        if(minst.isEmpty()) return-1;
        return minst.peek();
    }
}
