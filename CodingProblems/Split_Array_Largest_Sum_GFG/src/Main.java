//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String[] St = read.readLine().split(" ");

            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);

            String[] S = read.readLine().split(" ");

            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr, K));
        }
    }
}
// } Driver Code Ends


class Solution {
    private boolean check(int[] nums, int k, int maxSum) {
        int groups = 1;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (num > maxSum) return false;
            if (sum > maxSum) {
                ++groups;
                sum = num;
            }
            if (groups > k) return false;
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {
        // code here
        int l = 0;
        int r = Arrays.stream(nums).sum();

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(nums, k, mid)) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }
}