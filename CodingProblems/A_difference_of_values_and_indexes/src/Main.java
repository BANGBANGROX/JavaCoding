//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int n = Integer.parseInt(element[0]);

            int[] arr = new int[n];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }
            Solution obj = new Solution();
            int ans = obj.maxDistance(arr, n);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends


//User function Template for Java


class Solution {
    // Function for finding maximum and value pair
    public int maxDistance(int[] nums, int n) {
        //Complete the function
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            int sum = nums[i] + i;
            int diff = nums[i] - i;
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
            maxDiff = Math.max(maxDiff, diff);
            minDiff = Math.min(minDiff, diff);
        }

        return Math.max(maxSum - minSum, maxDiff - minDiff);
    }
}


