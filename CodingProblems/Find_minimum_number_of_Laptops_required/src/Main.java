//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i;
            int N = Integer.parseInt(br.readLine().trim());

            int[] start = new int[N];
            int[] end = new int[N];

            String[] inputLine2 = br.readLine().trim().split(" ");
            String[] inputLine3 = br.readLine().trim().split(" ");

            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minLaptops(int n, int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 1;
        int j = 0;
        int currentLaptops = 1;
        int ans = 1;

        while (i < n && j < n) {
            if (end[j] > start[i]) {
                ++currentLaptops;
                ++i;
            }
            else {
                ans = Math.max(ans, currentLaptops);
                --currentLaptops;
                ++j;
            }
        }

        ans = Math.max(ans, currentLaptops);

        return ans;
    }
}