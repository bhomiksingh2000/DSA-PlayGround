import java.util.*;
public class DFS {
    void dfs( ArrayList<ArrayList<Integer>> adj, int node, int [] vis, ArrayList<Integer> res){
        vis[node] = 1;
        res.add(node);
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, it, vis, res);
            }
        }

    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int nodes, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int [] vis = new int [nodes];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < nodes; i++){
            if(vis[i] == 0){
                dfs(adj, i, vis, res);
            }
        }

        return res;
    }
}
