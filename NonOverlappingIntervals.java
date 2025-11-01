import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = intervals[0]; 
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            // Overlapping Condtion Occurs : Check
            if(curr[0]<prev[1]){
                count++;  // If occur then increase count for remove Overlapped
                if(curr[1]<prev[1]) prev = curr;
            } else prev = curr;

        }
        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4}, {1,3}};
        int result = eraseOverlapIntervals(intervals);
        System.out.println("THE RESULT IS : " + result);
    }
}
