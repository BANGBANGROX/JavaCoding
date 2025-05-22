//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(final int[] arr) {
        // code here
        final int n = arr.length;
        final int lastD = Math.abs(arr[1] - arr[0]);

        for (int i = 2; i < n; ++i) {
            final int currentD = Math.abs(arr[i] - arr[i - 1]);
            if (currentD > lastD) {
                return (arr[i] + arr[i - 1]) / 2;
            } else if (currentD < lastD) {
                return (arr[i - 1] + arr[i - 2]) / 2;
            }
        }

        return arr[n - 1] + arr[1] - arr[0];
    }
}
