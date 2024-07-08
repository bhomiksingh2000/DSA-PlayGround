import java.util.*;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int nodes, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        int [] vis = new int[nodes];
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < nodes; i++){
            if(vis[i] == 0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while(q.size() > 0){
                    int node = q.peek();
                    res.add(node);
                    q.poll();
                    for(int it : adj.get(node)){
                        if(vis[it] == 0){
                            vis[it] = 1;
                            q.add(it);
                        }
                    }
                }
            }
        }



        return res;
    }
}
