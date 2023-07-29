//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] s = in.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            Solution ob = new Solution();
            long[] ans = ob.smallerSum(n, a);
            for (long i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private int getLastSmallerIndex(int[] nums, int key) {
        int l = 0;
        int r = nums.length;
        int result = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] >= key) r = mid - 1;
            else {
                result = mid;
                l = mid + 1;
            }
        }

        return result;
    }

    public long[] smallerSum(int n, int[] nums) {
        int[] sortedNums = nums.clone();
        long[] prefixSum = new long[n];
        long[] answer = new long[n];

        Arrays.sort(sortedNums);

        for (int i = 0; i < n; ++i) {
            if (i == 0) prefixSum[i] = sortedNums[i];
            else prefixSum[i] = prefixSum[i - 1] + sortedNums[i];
        }

        for (int i = 0; i < n; ++i) {
            int idx = getLastSmallerIndex(sortedNums, nums[i]);
            if (idx == -1) answer[i] = 0;
            else answer[i] = prefixSum[idx];
        }

        return answer;
    }
}