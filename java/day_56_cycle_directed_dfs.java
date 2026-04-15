import java.util.*;

public class Day56 {

    static boolean dfs(int node, boolean[] visited, boolean[] path, List<List<Integer>> adj) {

        visited[node] = true;
        path[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, path, adj))
                    return true;
            }
            else if (path[neighbor]) {
                return true;
            }
        }

        path[node] = false;
        return false;
    }

    static boolean isCycle(int n, List<List<Integer>> adj) {

        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, path, adj))
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
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // cycle

        System.out.println(isCycle(n, adj));
    }
}
