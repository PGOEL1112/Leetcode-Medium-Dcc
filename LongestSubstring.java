import java.util.HashMap;
public class LongestSubstring {
    class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        if(n<=1) return n;
        int maxlen=0;
        int i=0,j=0;
        HashMap<Character,Integer> Map = new HashMap<>();
        while(j<n){
            char ch = s.charAt(j);
            if(Map.containsKey(ch) && Map.get(ch)>=i){
                int len=j-i;
                maxlen = Math.max(maxlen,len);
                while(s.charAt(i)!=ch) i++;
                i++;
            }
            Map.put(ch,j);
            j++;
        }
        int len=j-i;
        maxlen=Math.max(maxlen,len);
        return maxlen;
    }
}
    
}
