import java.util.*;
public class ShortestPathInDirectedAcyclicGraph {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    void dfs(int i, ArrayList<ArrayList<Pair>> adjMatrix, int[] vis, Stack<Integer> st) {
        vis[i] = 1;

        for (Pair node : adjMatrix.get(i)) {
            if (vis[node.first] == 0) {
                dfs(node.first, adjMatrix, vis, st);
            }
        }

        // backtrack
        st.add(i);
    }

    public int[] shortestPath(int n, int m, int[][] edges) {
        // prepare adjacency matrix
        ArrayList<ArrayList<Pair>> adjMatrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int dis = edges[i][2];

            adjMatrix.get(u).add(new Pair(v, dis));
        }

        // first find the topological sort of the graph
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            vis[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, adjMatrix, vis, st);
            }
        }

        // Initialize distances to all vertices as infinite except the source vertex
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Assuming 0 is the source node
        distance[0] = 0;

        // Process nodes in topological order
        while (!st.isEmpty()) {
            int node = st.pop();

            // Update distances of all adjacent nodes
            if (distance[node] != Integer.MAX_VALUE) {
                for (Pair neighbor : adjMatrix.get(node)) {
                    if (distance[neighbor.first] > distance[node] + neighbor.second) {
                        distance[neighbor.first] = distance[node] + neighbor.second;
                    }
                }
            }
        }

        // Replace any remaining Integer.MAX_VALUE with -1 to indicate unreachable nodes
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}

/*
https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/#

Finding the shortest path to a vertex is easy if you already know the shortest paths
to all the vertices that can precede it. Processing the vertices in topological order
ensures that by the time you get to a vertex, you've already processed all the vertices
that can precede it which reduces the computation time significantly. In this approach,
 we traverse the nodes sequentially according to their reachability from the source.

Dijkstra's algorithm is necessary for graphs that can contain cycles because they can't be
topologically sorted. In other cases, the topological sort would work fine as we start from
the first node, and then move on to the others in a directed manner.
 */
