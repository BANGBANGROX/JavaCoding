//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int answer = 0;
        int n = arr.length;
        int currentSum = 0;
        Map<Integer, Integer> sumIndex = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            currentSum += (arr[i] == 1 ? 1 : -1);
            if (currentSum == 0) {
                answer = i + 1;
            }
            if (sumIndex.containsKey(currentSum)) {
                answer = Math.max(answer, i - sumIndex.get(currentSum));
            } else {
                sumIndex.put(currentSum, i);
            }
        }

        return answer;
    }
}
