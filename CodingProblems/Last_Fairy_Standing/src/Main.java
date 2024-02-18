//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int k;
            k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.lastFairyStanding(n, k);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    public int lastFairyStanding(int n, int k) {
        // code here
        if (n == 1) return 1;

        return (lastFairyStanding(n - 1, k) + k - 1) % n + 1;
    }
}

