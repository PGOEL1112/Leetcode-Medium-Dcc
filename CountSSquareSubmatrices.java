public class CountSSquareSubmatrices {
    private static int CountSquares(int[][] nums) {
       int m = nums.length;
       int n = nums[0].length;
       int count =0;
       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(nums[i][j]==0) continue;
            if(i!=0 && j!=0){
                nums[i][j] += Math.min(nums[i-1][j],Math.min(nums[i][j-1],nums[i-1][j-1]));
            }
            count+=nums[i][j];
        }
       }
       return count;
    }
    public static void main(String[] args) {
        int[][] nums = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(CountSquares(nums));
    }

    
}
