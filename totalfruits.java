import java.util.*;
public class totalfruits {
    public static int helper(int[] fruits){
        int n = fruits.length; 
        int i =0, j=0, maxlen=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(j<n){
            // Step-1 : Include fruits[j] in the window
            map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);


            // Step-2 : map contains only two different fruits
            while(map.size()>2){
                map.put(fruits[i], map.get(fruits[i])-1);
                if(map.get(fruits[i])==0) map.remove(fruits[i]);
                i++;
            }

            // Step-3 : Update the maxlen that can be collect by maintaing two different fruits
            int len = j-i+1;
            maxlen = Math.max(maxlen,len);
            j++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        int ans = helper(fruits);

        System.out.println("THE MAXIMUM NUMBER OF FRUITS THAT CAN BE COLLECTED IS :" +ans);
    }
    
}
