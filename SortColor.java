public class SortColor {
    class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;

        int low = 0 , mid = 0 , high = n-1;
        while (mid <= high) {
            if(arr[mid] ==0) {
                int temp = arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }

            else if(arr[mid] ==1)
                mid++;

            else {//arr[mid]==2
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
}
