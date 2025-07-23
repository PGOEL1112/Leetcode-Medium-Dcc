public class SearchInRsa {
    class Solution {
    public int search(int[] arr, int target) {
        int m = arr.length;
        int low=0, high=m-1;

        // we are travelling in right sorted array
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<=arr[high]) {
                if(arr[mid]<target && target<=arr[high]) {
                    low=mid+1;
                } else high=mid-1;
            } 

            // treverse in left sorted array 
            else {
                if(target>=arr[low] && target<arr[mid])
                high=mid-1;

                else 
                low=mid+1;
            }
        }
        return -1;        
    }
}
    
}
