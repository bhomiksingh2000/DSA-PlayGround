import java.util.*;
public class ShortestPathInUndirectedGraph {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjMatrix.get(u).add(v);
            adjMatrix.get(v).add(u);
        }

        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // BFS to find shortest path from source to all vertices
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        distance[src] = 0;

        while(q.size() > 0){
            int node = q.poll();
            for(int neighbour : adjMatrix.get(node)){
                if(distance[neighbour] > distance[node] + 1){
                    distance[neighbour] = distance[node] + 1;
                    q.add(neighbour);
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
https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/
 */
