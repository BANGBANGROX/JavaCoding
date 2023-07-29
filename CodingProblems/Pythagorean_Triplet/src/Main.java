//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    public boolean checkTriplet(int[] nums, int n) {
        // code here
        if (nums.length == 0) return false;

        int maxValue = Arrays.stream(nums).max().getAsInt();
        boolean[] isPresent = new boolean[maxValue + 1];

        for (int i = 0; i < n; ++i) {
            isPresent[nums[i]] = true;
        }

        for (int c = 1; c <= maxValue; ++c) {
            for (int a = 1; a < c; ++a) {
                if (!isPresent[c] || !isPresent[a]) continue;
                int bSquare = c * c - a * a;
                double b = Math.sqrt(bSquare);
                if (Math.floor(b) == b && isPresent[(int) b]) {
                    return true;
                }
            }
        }

        return false;
    }
}