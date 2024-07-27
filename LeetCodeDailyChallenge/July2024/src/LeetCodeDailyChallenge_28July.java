import java.util.*;
public class LeetCodeDailyChallenge_28July {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int [][] adjMatrix = new int [26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }

        for(int  i = 0; i < original.length; i++){
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int c = cost[i];

            adjMatrix[u][v] = Math.min(c, adjMatrix[u][v]);

        }

        // FLOYD WARSHALL ALGO
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (adjMatrix[i][k] == Integer.MAX_VALUE || adjMatrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        long totalCost = 0;
        for(int i = 0; i < source.length(); i++){
            int reqCost = adjMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if(reqCost == Integer.MAX_VALUE){
                return -1;
            }
            totalCost += reqCost;
        }

        return totalCost;
    }

}








/*
DIJKSTRA IS GIVING TLE :
class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    void dijkstraAlgo(int src, ArrayList<ArrayList<Pair>> adjMatrix, int[] distances) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.second));

        pq.add(new Pair(src, 0));
        distances[src] = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.first;
            int distance = pair.second;
            // System.out.println("Node : "+ node);
            // System.out.println("distance : " + distance);

            for (Pair neighbor : adjMatrix.get(node)) {
                int nextNode = neighbor.first;
                int nextNodeDistance = neighbor.second;

                // System.out.println("nextNode : "+ nextNode);
                // System.out.println("nextNodeDistance : "+ nextNodeDistance);

                if (distances[nextNode] > nextNodeDistance + distance) {
                    distances[nextNode] = nextNodeDistance + distance;
                    pq.add(new Pair(nextNode, distances[nextNode]));
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        ArrayList<ArrayList<Pair>> adjMatrix = new ArrayList<>(26);

        for (int i = 0; i < 26; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int c = cost[i];

            adjMatrix.get(u).add(new Pair(v, c));
        }

        int total = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int[] distances = new int[26];
                Arrays.fill(distances, Integer.MAX_VALUE);

                dijkstraAlgo(source.charAt(i) - 'a', adjMatrix, distances);
                int transformationCost = distances[target.charAt(i) - 'a'];

                if(transformationCost == Integer.MAX_VALUE){
                    return -1;
                }

                total += transformationCost;
            }
        }

        return total;

    }
}
 */
