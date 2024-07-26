import java.util.*;
public class LeetCodeDailyChallenge_26July {
    private void dijkstraAlgo(int i, List<List<Pair>> adjMatrix, int[] distances) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

        pq.add(new Pair(i, 0));
        distances[i] = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int distance = pair.distance;

            for (Pair neighbor : adjMatrix.get(node)) {
                int nextNode = neighbor.node;
                int nextNodeDistance = neighbor.distance;

                if (distances[nextNode] > nextNodeDistance + distance) {
                    distances[nextNode] = nextNodeDistance + distance;
                    pq.add(new Pair(nextNode, distances[nextNode]));
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adjMatrix = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int dis = edge[2];

            adjMatrix.get(u).add(new Pair(v, dis));
            adjMatrix.get(v).add(new Pair(u, dis));
        }

        int res = -1;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            dijkstraAlgo(i, adjMatrix, distances);

            int tempCount = 0;
            for (int j = 0; j < n; j++) {
                if (distances[j] <= distanceThreshold) {
                    tempCount++;
                }
            }

            if (tempCount <= count) {
                count = tempCount;
                res = i;
            }
        }

        return res;
    }

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
