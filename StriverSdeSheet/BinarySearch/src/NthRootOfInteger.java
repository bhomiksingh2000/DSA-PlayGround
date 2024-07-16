import java.util.*;
public class NthRootOfInteger {
    int NthRoot(int n, int m) {
        // Write your code here.
        int s = 1;
        int e = m;

        while(s <= e){
            int mid = s + (e - s)/2;

            // int x = pow(n, mid);
            double x = Math.pow(mid, n);

            if(x == m){
                return mid;
            }

            else if(x < m){
                s = mid + 1;
            }

            else{
                e = mid - 1;
            }
        }

        return -1;
    }
}
