import java.util.*;

public class Day68 {

    static int orangesRotting(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // initialize queue with rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                int[] curr = q.poll();

                for (int[] d : dir) {

                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];

                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        fresh--;
                        q.add(new int[]{ni, nj});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        System.out.println(orangesRotting(grid));
    }
}
