import java.util.*;
public class isBipartiteBFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] color = new boolean[n];
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                color[i] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while (!q.isEmpty()) {
                    int node = q.poll();
                    vis[node] = 1;

                    for (int neighbor : graph[node]) {
                        if (vis[neighbor] == 0) {
                            color[neighbor] = !color[node];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }

}
