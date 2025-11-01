import java.util.Arrays;

public class MergeIntervals {
    public static int[][] Merged(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int k=0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[k][1] >=intervals[i][0]){
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            }
            else {
                k++;
                intervals[k] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals, 0,k+1);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] ans = Merged(intervals);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
