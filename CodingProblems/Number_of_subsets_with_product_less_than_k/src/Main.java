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
            int N = Integer.parseInt(read.readLine());

            String[] S = read.readLine().split(" ");
            int[] arr = new int[N];

            int K = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.numOfSubsets(arr, N, K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] nums;
    private int n;
    private int k;
    private int ans = -1;

    private void numOfSubsetsUtil(int i, int currentProduct) {
        if (i == n) {
            if (currentProduct <= k) ++ans;
            return;
        }

        if (currentProduct <= k) {
            numOfSubsetsUtil(i + 1, currentProduct * nums[i]);
        }

        numOfSubsetsUtil(i + 1, currentProduct);
    }

    public int numOfSubsets(int[] nums, int n, int k) {
        // code here
        this.nums = nums;
        this.n = n;
        this.k = k;

        numOfSubsetsUtil(0, 1);

        return ans;
    }
}