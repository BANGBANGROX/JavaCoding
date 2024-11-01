//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long[] arr) {
        // code here
        long answer = 0;
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        List<Long> finalNums = new ArrayList<>();

        Arrays.sort(arr);

        while (left < right) {
            finalNums.add(arr[left]);
            finalNums.add(arr[right]);
            ++left;
            --right;
        }

        if (left == right) {
            finalNums.add(arr[left]);
        }

        for (int i = 1; i < n; ++i) {
            answer += Math.abs(finalNums.get(i) - finalNums.get(i - 1));
        }

        answer += Math.abs(finalNums.get(n - 1) - finalNums.getFirst());

        return answer;
    }
}


// Driver Code Starts.
public class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends