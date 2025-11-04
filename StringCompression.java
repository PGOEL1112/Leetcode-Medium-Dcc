import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static  int compress(char[] chars) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for (char c : chars) {
            char newC = Character.toLowerCase(c);
            freq.put(newC,freq.getOrDefault(newC,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            if(entry.getValue()==1){
                sb.append(entry.getKey());
            }
            else {
                sb.append(entry.getKey());
                sb.append(entry.getValue());
            }
        }

        return sb.length();
        
    }
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int result = compress(chars);
        System.out.println(result);
    }
}
