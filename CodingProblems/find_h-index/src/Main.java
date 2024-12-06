//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private int lowerBound(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] >= key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        Arrays.sort(citations);

        int n = citations.length;
        int left = citations[0];
        int right = citations[n - 1];
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            int idx = lowerBound(citations, mid);
            int elements = n - idx;
            if (elements >= mid) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}