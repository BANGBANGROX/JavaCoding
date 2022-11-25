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
            //br.readLine();
            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.beautySum(s);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int beautySum(String s) {
        // code here
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            int[] count = new int[26];
            for (int j = i; j < n; ++j) {
                ++count[s.charAt(j) - 'a'];
                int maxF = Integer.MIN_VALUE;
                int minF = Integer.MAX_VALUE;
                for (int k = 0; k < 26; ++k) {
                    if (count[k] == 0) continue;
                    maxF = Math.max(maxF, count[k]);
                    minF = Math.min(minF, count[k]);
                }
                //System.out.println(maxF + " " + minF);
                ans += (maxF - minF);
            }
        }

        return ans;
    }
}

