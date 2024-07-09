import java.util.*;
public class topologicalSortDFS {
    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int [] vis, Stack<Integer> stack){
        vis[node] = 1;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis, stack);
            }
        }

        stack.push(node);
        return ;
    }
     int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int [] vis = new int[v];
        Stack<Integer> stack = new Stack<>();



        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, stack);
            }
        }

        int[] res = new int[v];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }

        return res;
    }
}
