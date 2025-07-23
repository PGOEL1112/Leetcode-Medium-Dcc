import java.util.Stack;

public class SimplifyPath {
    class Solution {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> st = new Stack<>();
        for(int i =-0 ; i<arr.length ; i++){
            if(!st.isEmpty() &&  arr[i].equals("..")) st.pop();
            if((arr[i].equals("")==false) && (arr[i].equals(".")==false) && (arr[i].equals("..")==false)) st.push(arr[i]);
        }
        if(st.isEmpty()) return "/";
        StringBuilder ans = new StringBuilder();
        for(String curr : st){
            ans.append('/');
            ans.append(curr);
        }
        return ans.toString();
        
    }
}
}
