public class LeetCodeDailyChallenge_10July {
    public int minOperations(String[] logs) {
        int currLevel = 0;
        for(int i = 0; i < logs.length; i++){

            String temp = logs[i];

            if(temp.charAt(0) == '.'){
                if(temp.charAt(1) == '.'){
                    if(currLevel >= 1){
                        currLevel--;
                    }
                }
            }

            else{
                currLevel++;
            }
        }

        return currLevel;
    }
}
