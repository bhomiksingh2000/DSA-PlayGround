import java.util.*;
public class topolgicalSortBFS {
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int [] indegree = new int[v];
        int [] res = new int[v];
        int index = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < v; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            res[index] = node;
            index++;

            for(int it : adj.get(node)){
                indegree[it] --;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return res;
    }
}
