//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        ob.precompute();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input_line = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long R = Long.parseLong(input_line[1]);
            long ans = ob.solve(L, R);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    private final HashSet<Long> nums = new HashSet<>();

    private void construct(int idx, int setBits, long num) {
        if (idx == 64) {
            if (setBits == 0) nums.add(num);
            return;
        }

        if (setBits > 0) {
            construct(idx + 1, setBits - 1, 2 * num + 1);
        }

        construct(idx + 1, setBits, 2 * num);
    }

    public long solve(long l, long r){
        // Code here
        int ans = 0;

        for (long x : nums) {
            if (x >= l && x <= r) ++ans;
        }

        return ans;
    }

    public void precompute() {
        construct(0, 3, 0);
    }
}
