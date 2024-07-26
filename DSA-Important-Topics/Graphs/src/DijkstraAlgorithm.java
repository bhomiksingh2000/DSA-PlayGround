public class DijkstraAlgorithm {
    /*
    void dijkstraAlgo(int i, vector<vector<pair<int, int>>>& adjMatrix,
                      vector<int>& distances) {

        priority_queue<pair<int, int>, vector<pair<int, int>>,
                       greater<pair<int, int>>>
            pq;

        pq.push({0, i});
        distances[i] = 0;

        while (pq.size() > 0) {
            int node = pq.top().second;
            int distance = pq.top().first;
            pq.pop();

            for (auto it : adjMatrix[node]) {
                int nextNode = it.first;
                int nextNodeDistance = it.second;

                if (distances[nextNode] > nextNodeDistance + distance) {
                    distances[nextNode] = nextNodeDistance + distance;
                    pq.push({distances[nextNode], nextNode});
                }
            }
        }
    }
     */
}
