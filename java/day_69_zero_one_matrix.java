import java.util.*;

public class Day69 {

    static int[][] updateMatrix(int[][] mat) {

        int n = mat.length, m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            for (int[] d : dir) {

                int ni = curr[0] + d[0];
                int nj = curr[1] + d[1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m && dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };

        int[][] res = updateMatrix(mat);

        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
