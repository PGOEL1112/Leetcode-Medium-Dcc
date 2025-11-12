public class MinimumNumberOperationsToMakeElements {
    public static int gcd(int a, int b){
        return b==0 ? a : gcd(b, (a%b));
    }
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int Operations = 0;
        
        int ones = 0;
        for(int ele : nums){
            if(ele==1) ones++;
        }

        if(ones>0) return n-ones;

        
        for(int i=n-2; i>=0; i--){
           nums[i] =  gcd(nums[i],nums[i+1]);
           Operations++;
        }

        nums[n-1] = gcd(nums[n-1],nums[n-2]);
        Operations++;

        return (Operations!=0) ? Operations : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,3,4};
        int result = minOperations(nums);
        System.out.println(result);
    }
}
