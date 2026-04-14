import java.util.*;

public class Day55 {

    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj))
                    return true;
            }
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    static boolean isCycle(int n, List<List<Integer>> adj) {

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1); // cycle

        System.out.println(isCycle(n, adj));
    }
}
