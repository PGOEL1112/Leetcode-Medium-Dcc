public class IncrementOne {
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grid = new int[n][n];

        for (int[] q : queries) {
            int row1 = q[0], col1 = q[1];
            int row2 = q[2], col2 = q[3];

            for (int r = row1; r <= row2; r++) {
                for (int c = col1; c <= col2; c++) {
                    grid[r][c]++;
                }
            }
        }

        return grid;
    }
    public static void main(String[] args) {
        int[][] queries = {{1,1,2,2}, {0,0,1,1}};
        int n = 3;

        int[][] result = rangeAddQueries(n,queries);
        for (int j = 0; j < result.length; j++) {
            for (int j2 = 0; j2 < result.length; j2++) {
                System.out.print(result[j][j2] + " ");
            }
            System.out.println();
        }
    }
}
