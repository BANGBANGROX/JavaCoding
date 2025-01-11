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
    public int countPairs(int[] arr, int target) {
        // Complete the function
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (int num : arr) {
            answer += count.getOrDefault(target - num, 0);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return answer;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends