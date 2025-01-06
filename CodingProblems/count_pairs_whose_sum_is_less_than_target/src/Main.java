//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public int countPairs(int[] nums, int target) {
        // Your code here
        int answer = 0;
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        Arrays.sort(nums);

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum >= target) {
                --right;
            } else {
                answer += (right - left);
                ++left;
            }
        }

        return answer;
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends