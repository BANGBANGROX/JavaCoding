//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){
            String[] input_line = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int[] A = new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, M);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private long countSubarrayUtil(int n, int[] nums, int m) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int current = 0;
        int total = 0;
        long ans = 0;

        count.put(current, 1);

        for (int i = 0; i < n; ++i) {
            int change = (nums[i] >= m ? 1 : -1);
            if (change == 1) total += count.getOrDefault(current, 0);
            else total -= count.getOrDefault(current - 1, 0);
            current += change;
            ans += total;
            count.put(current, count.getOrDefault(current, 0) + 1);
        }

        return ans;
    }

    public long countSubarray(int n, int[] nums, int m) {
        // code here
        return countSubarrayUtil(n, nums, m) - countSubarrayUtil(n, nums, m + 1);
    }
}