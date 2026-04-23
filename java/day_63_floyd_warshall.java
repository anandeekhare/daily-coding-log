import java.util.*;

public class Day63 {

    static final int INF = 1000000000;

    static void floydWarshall(int[][] dist, int n) {

        for (int via = 0; via < n; via++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][via] < INF && dist[via][j] < INF) {
                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][via] + dist[via][j]
                        );
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] dist = {
            {0,   3, INF, 7},
            {8,   0, 2,   INF},
            {5, INF, 0,   1},
            {2, INF, INF, 0}
        };

        floydWarshall(dist, n);
    }
}
