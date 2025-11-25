import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

    static class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void bfs(int i, int j, boolean[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;

            // Up
            if (row > 0 && !vis[row - 1][col] && grid[row - 1][col] == '1') {
                vis[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
            }
            // Down
            if (row + 1 < n && !vis[row + 1][col] && grid[row + 1][col] == '1') {
                vis[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
            }
            // Right
            if (col + 1 < m && !vis[row][col + 1] && grid[row][col + 1] == '1') {
                vis[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
            }
            // Left
            if (col > 0 && !vis[row][col - 1] && grid[row][col - 1] == '1') {
                vis[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        NoOfIslands obj = new NoOfIslands();
        int count = obj.numIslands(grid);
        System.out.println(count);
    }
}
