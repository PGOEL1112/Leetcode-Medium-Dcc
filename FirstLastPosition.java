public class FirstLastPosition {
    class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] ans = new int[2];
        int m = arr.length;

        // first position
        int low, high,firstposition;
        low=0; high=m-1; firstposition=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target) {
                if(mid>0 && arr[mid]==arr[mid-1]) {
                    high=mid-1;
                }
                    else {
                        firstposition=mid;
                        break;
                    }
            } 
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }    

        // last position   
        low=0; high=m-1; 
        int lastposition=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target) {
                if((mid+1)<m && arr[mid]==arr[mid+1]) {
                    low=mid+1;
                }
                    else {
                        lastposition=mid;
                        break;
                    }
            } 
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }  

        ans[0]=firstposition;
        ans[1]=lastposition;
        return ans;  
    }
}
}
