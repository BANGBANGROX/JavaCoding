//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int longestSubarray(final int[] arr, final int k) {
        // Code Here
        final int n = arr.length;
        final Map<Integer, Integer> firstIndex = new HashMap<>();
        int answer = 0;
        int runningCounter = 0;

        for (int i = 0; i < n; ++i) {
            if (arr[i] > k) {
                ++runningCounter;
            } else {
                --runningCounter;
            }
            if (runningCounter > 0) {
                answer = i + 1;
            }
            if (firstIndex.containsKey(runningCounter - 1)) {
                answer = Math.max(answer, i - firstIndex.get(runningCounter - 1));
            }
            if (!firstIndex.containsKey(runningCounter)) {
                firstIndex.put(runningCounter, i);
            }
        }

        return answer;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends