//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);

            String[] S1 = read.readLine().split(" ");

            int[] arr = new int[N];

            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxGroupSize(arr, K));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxGroupSize(int[] nums, int k) {
        // code here
        int[] rem = new int[k];

        for (int x : nums) {
            ++rem[x % k];
        }

        int l = 1;
        int r = k - 1;
        int ans = 0;

        while (l <= r) {
            if (l == r && rem[l] > 0) {
                ++ans;
                break;
            }
            ans += Math.max(rem[l], rem[r]);
            ++l;
            --r;
        }

        if (rem[0] > 0) ++ans;

        return ans;
    }
}