import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDnaSequence {
    public static List<String> findRepeatedDnaSequences(String s) {
        int length = 10;

        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();


        // window nikallow
        for (int i = 0; i + length <= s.length(); i++) {
            String sub = s.substring(i,i+length);
                if(!seen.add(sub)){
                    repeated.add(sub);
                }
        }
        return new ArrayList<>(repeated);
    }
    
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedDnaSequences(s);
        System.out.println(result); 
    }
}
