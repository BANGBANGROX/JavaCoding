//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] arr = br.readLine().split(" ");
            int[] prices = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumProfit(int[] prices) {
        // Code here
        int answer = 0;
        int n = prices.length;
        int minPrice = prices[0];

        for (int i = 1; i < n; ++i) {
            if (prices[i] > minPrice) {
                answer = Math.max(answer, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }

        return answer;
    }
}