import java.util.*;
public class AdjacentIncreasingSubarraysDetectionII {
    public static int maxIncreasingSubarrays(List<Integer> list){
        int n = list.size();
        if(n==0) return 0;
        int prevlen = 0, currlen =1, maxlen = 0;
        for(int i=1; i<n; i++){
            if(list.get(i)>list.get(i-1)){
                currlen++;
            }
            else{
                prevlen = currlen;
                currlen =1;
            }
            
            maxlen = Math.max(maxlen,Math.max((currlen/2),Math.min(currlen,prevlen)));
            
        }
        return maxlen;

    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(4);
            list.add(4);
            list.add(4);
            list.add(5);
            list.add(6);
            list.add(7);

        int ans = maxIncreasingSubarrays(list);
        System.out.println("THE MAXIMUM NUMBER OF  ADJACENT INCREASING SUBARRAYS IS : "+ans);

    }
}
