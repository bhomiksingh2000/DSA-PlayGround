import java.util.*;
public class LeetCodeDailyChallenge_6Aug {
    public int minimumPushes(String word) {
        var res = 0;
        var cnt = 0;
        var freq = new int[26];

        for (var c : word.toCharArray())
            freq[c - 'a']++;

        Arrays.sort(freq);

        for (var i = 25; i >= 0; i--)
            if (freq[i] > 0)
                res += freq[i] * (cnt++ / 8 + 1);

        return res;
    }
}

/*
BRUTE FORCE :
int minimumPushes(string word) {
        unordered_map<char, int> mp;
        for(auto it : word){
            mp[it]++;
        }

        vector<pair<char, int>> vec(mp.begin(), mp.end());

        // Sort the vector by the second element (the value)
        sort(vec.begin(), vec.end(),
             [](const pair<char, int>& a, const pair<char, int>& b) {
                 return a.second > b.second;
             });

        int count = 0;
        for(int i = 0; i < vec.size(); i++){
            cout<<"Key :"<<vec[i].first<<endl;
            cout<<"value"<<vec[i].second<<endl;

            if(i <= 7){
                count += vec[i].second;
                cout<<"LESS THAN 8 CHARACTERS :" <<count<<endl;
                cout<<endl;
            }

            else if(i <= 15){
                count += 2 * (vec[i].second);
                cout<<"LESS THAN 16 CHARACTERS :" <<count<<endl;
                cout<<endl;
            }

            else if(i <= 23){
                count += 3 * (vec[i].second);
                cout<<"LESS THAN 24 CHARACTERS :" <<count<<endl;
                cout<<endl;
            }

            else{
                count += 4 * (vec[i].second);
                cout<<"MORE THAN 24 CHARACTERS :" <<count<<endl;
                cout<<endl;
            }
        }

        return count;
    }

 */
