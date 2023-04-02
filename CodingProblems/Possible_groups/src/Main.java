//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            long ans = new Solution().findgroups(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public long findgroups(int[] nums, int n) {
        // code here
        long[] count = new long[3];

        for (int num : nums) {
            ++count[num % 3];
        }

        return count[0] * (count[0] - 1) / 2 + count[1] * count[2] + count[0] * (count[0] - 1) * (count[0] - 2) / 6 + count[0] * count[1] * count[2] + count[1] * (count[1] - 1) * (count[1] - 2) / 6 + count[2] * (count[2] - 1) * (count[2] - 2) / 6;
    }
}
