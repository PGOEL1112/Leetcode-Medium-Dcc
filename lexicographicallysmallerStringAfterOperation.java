import java.util.*;

public class lexicographicallysmallerStringAfterOperation {
    public static String findLexicographicallySmallestString(String s , int a, int b){
        String smallest = s;
        int n = s.length();

        //  by bfs approach
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.add(s);
        visited.add(s);

        while(!q.isEmpty()){
            String curr = q.poll();

            // Operation 1 : Add 'a' to all odd indices
            char[] oddAdded = curr.toCharArray();
            for(int i=1; i<n; i+=2){
                oddAdded[i] = (char)(((oddAdded[i]- '0'+ a) % 10 ) + '0');
            }
            
            String oddAddedStr = new String(oddAdded);
            if(!visited.contains(oddAddedStr)){
                visited.add(oddAddedStr);
                q.add(oddAddedStr);
                if(oddAddedStr.compareTo(smallest)<0){
                    smallest = oddAddedStr;
                }
            }

            // Operation 2 : Rotate the String by b positions
            String rotated = curr.substring(n-b) + curr.substring(0,n-b);
            if(!visited.contains(rotated)){
                visited.add(rotated);
                q.add(rotated);
                if(rotated.compareTo(smallest)<0){
                    smallest = rotated;
                }
            }
        }
        return smallest;

       
    }
    public static void main(String[] args) {
        String s = "5525";
        int a = 9;
        int b = 2;
        String result = findLexicographicallySmallestString(s,a,b);
        System.out.println(result);
    }
}
