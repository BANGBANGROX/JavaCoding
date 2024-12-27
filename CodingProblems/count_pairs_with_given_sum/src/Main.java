//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


// } Driver Code Ends
class Solution {
    public int countPairs(int[] arr, int target) {
        // Your code here
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