import java.util.*;
public class cycleDetectionInDirectedGraphDFS {
    boolean isCycle(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfsVis) {
        vis[i] = 1;
        dfsVis[i] = 1;

        for (int it : adj.get(i)) {
            if (vis[it] == 0) {
                if (isCycle(it, adj, vis, dfsVis)) {
                    return true; // cycle is there
                }
            }

            else {
                if (dfsVis[it] == 1)
                    return true; // cycle is there
            }

        }

        dfsVis[i] = 0;
        return false;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }

        int[] vis = new int[numCourses];
        int[] dfsVis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (isCycle(i, adj, vis, dfsVis) == true) {
                    return false;
                }
            }

        }

        return true;
    }
}
