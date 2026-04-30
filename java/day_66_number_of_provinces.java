import java.util.*;

public class Day66 {

    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int[] rank, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1) {
                    union(parent, rank, i, j);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };

        System.out.println(findCircleNum(matrix));
    }
}
