public class LeetCodeDailyChallenge_8July {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        int tempk = k;
        while(q.size() > 1){

            while(tempk - 1 > 0){
                int frontPlayer = q.peek();
                q.poll();
                q.add(frontPlayer);
                tempk--;
            }

            q.poll();

            tempk = k;
        }

        return q.peek();

    }
}
