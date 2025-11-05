public class WordSearch {
    private static boolean dfs(char[][] board, String word, int i, int j, int k) {
        // Base case: all characters matched
        if (k == word.length()) return true;

        // Out of bounds OR character mismatch → stop
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(k)) {
            return false;
        }

        // Temporarily mark this cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore 4 directions (up, down, left, right)
        boolean found =
            dfs(board, word, i + 1, j, k + 1) ||
            dfs(board, word, i - 1, j, k + 1) ||
            dfs(board, word, i, j + 1, k + 1) ||
            dfs(board, word, i, j - 1, k + 1);

        // Restore the cell after exploring
        board[i][j] = temp;

        return found;
    }
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;  // found a valid path
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean ans = exist(board,word);
        System.out.println(ans);
    }
    
}
