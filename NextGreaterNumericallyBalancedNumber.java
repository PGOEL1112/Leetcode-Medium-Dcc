import java.util.HashMap;
import java.util.Map;

public class NextGreaterNumericallyBalancedNumber {
    private  boolean isBalanced(int n){
        Map<Integer,Integer> map = new HashMap<>();

        int temp = n;
        while(temp>0){
            int rem = temp%10;
            map.put(rem,map.getOrDefault(rem,0)+1);
            temp = temp / 10;
        }

        for(int key : map.keySet()){
            if(key!=map.get(key)) return false;
        }
        return true;
    }

    private int nextBeautifulNumber(int n){
        while(true){
            n = n+1;
            if(isBalanced(n)) return n; 
        }
    }


    public static void main(String[] args) {
        int n = 1;
        NextGreaterNumericallyBalancedNumber obj = new NextGreaterNumericallyBalancedNumber();
        int result = obj.nextBeautifulNumber(n);
        System.out.println("The answer is :" +result);
    }
}
