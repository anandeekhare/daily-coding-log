public class Day70 {

    static void dfs(char[][] board, int i, int j) {

        int n = board.length, m = board[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O')
            return;

        board[i][j] = 'T';

        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

    static void solve(char[][] board) {

        int n = board.length, m = board[0].length;

        // boundary DFS
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m-1);
        }

        for (int j = 0; j < m; j++) {
            dfs(board, 0, j);
            dfs(board, n-1, j);
        }

        // flip
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}
