import java.util.*;
public class isBipartiteDFS {
    boolean dfs(int[][] graph, int node, int n, int [] color, int [] vis, int prevColor){
        vis[node] = 1;
        if(prevColor == 1){
            color[node] = 0;
        }

        else{
            color[node] = 1;
        }

        for(int it : graph[node]){
            if(vis[it] == 0){
                if(dfs(graph, it, n, color, vis, color[node])){
                    return true;
                }
            }

            else{
                if(color[it] == color[node]){
                    return true;
                }
            }
        }

        return false;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] color = new int[n];
        int [] vis = new int [n];


        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                if(dfs(graph, i, n, color, vis, 1)){
                    return false;
                }
            }
        }

        return true;


    }
}
