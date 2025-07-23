public class Mostwater {
    class Solution {
    public int maxArea(int[] height) {
        int maxwater = 0;
        int lp=0;
        int rp = height.length-1;
        while(lp<rp){
            int ht = Math.min(height[lp], height[rp])*(rp-lp);
            maxwater = Math.max(maxwater , ht);
            if(height[lp]<height[rp]){
                lp++;
            }
            else rp--;
        }
        return maxwater;
    }
}
    
}
