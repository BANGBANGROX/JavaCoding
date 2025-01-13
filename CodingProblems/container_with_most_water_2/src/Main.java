//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxWater(int[] nums) {
        // Code Here
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int answer = 0;
        int maxLeft = nums[left];
        int maxRight = nums[right];

        while (left < right) {
            maxLeft = Math.max(maxLeft, nums[left]);
            maxRight = Math.max(maxRight, nums[right]);
            if (maxLeft < maxRight) {
                answer = Math.max(answer, (right - left) * maxLeft);
                ++left;
            } else {
                answer = Math.max(answer, (right - left) * maxRight);
                --right;
            }
        }

        return answer;
    }
}