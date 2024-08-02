public class LeetCodeDailyChallenge_1Aug {
    public int countSeniors(String[] details) {
        int count = 0;
        for(int i = 0; i < details.length; i++){
            String age = "" + details[i].charAt(11) + details[i].charAt(12);

            if(Integer.valueOf(age) > 60){
                count++;
            }
        }

        return count;
    }
}
