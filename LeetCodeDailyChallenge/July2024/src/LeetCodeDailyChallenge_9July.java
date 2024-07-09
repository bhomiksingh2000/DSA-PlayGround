import java.util.*;

// 1701. Average Waiting Time
public class LeetCodeDailyChallenge_9July {
    public double averageWaitingTime(int[][] customers) {
        int currTime = customers[0][0];
        double totalWaitingTime = 0;

        for(int i = 0; i < customers.length; i++){
            int waitingTimeForEachCustomer;

            if(currTime >= customers[i][0]){
                waitingTimeForEachCustomer = currTime -  customers[i][0] + customers[i][1];
                currTime += customers[i][1];
            }

            else{
                waitingTimeForEachCustomer =  customers[i][1];
                currTime = customers[i][0] + customers[i][1];
            }

            totalWaitingTime += waitingTimeForEachCustomer;

        }

        return totalWaitingTime / customers.length;
}
}
