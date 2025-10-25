import java.util.TreeSet;

public class SmallerOnLeft {
    public static int[] helper(int[] arr, int n){
        int[] result = new int[n];

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            Integer smaller = set.lower(arr[i]);  // greatest element smaller than arr[i]
            result[i] = (smaller == null) ? -1 : smaller;
            set.add(arr[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 2, 5, 5, 4, 2, 5};
        int n = arr.length;

        int[] result = helper(arr,n);

        for(int val : result){
            System.out.print(val + " ");
        }

    }
}
