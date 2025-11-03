public class MinimumTimeToMakeRopeColorful {
    public static int minCost(String colors, int[] neededTime) {
        int requiredTime = 0;
        int i =0 ;
        while(i<colors.length()-1){
            if(colors.charAt(i)==colors.charAt(i+1)){
                requiredTime +=Math.min(neededTime[i],neededTime[i+1]);
                neededTime[i+1] = Math.max(neededTime[i], neededTime[i+1]);
            }
            i++;
        }
        return requiredTime;
    }

    public static void main(String[] args) {
        String colors = "aabaaaa";
        int[] neededTime = {1,2,3,4,1,7,8};
        int result = minCost(colors,neededTime);
        System.out.println(result);
    }
}
