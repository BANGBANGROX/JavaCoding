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

            Solution obj = new Solution();
            int res = obj.noConseBits(n);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int noConseBits(int n) {
        // code here
        int ans = 0;
        int ones = 0;

        for (int i = 31; i >= 0; --i) {
            if ((n & (1 << i)) > 0) {
                if (ones < 2) {
                    ++ones;
                    ans = ans * 2 + 1;
                }
                else {
                    ans = ans * 2;
                    ones = 0;
                }
            }
            else {
                ans = ans * 2;
                ones = 0;
            }
        }

        return ans;
    }
}

