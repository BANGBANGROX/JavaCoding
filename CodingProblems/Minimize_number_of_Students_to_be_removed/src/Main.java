//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String[] S = read.readLine().split(" ");
            int[] H = new int[N];

            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.removeStudents(H,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int lowerBound(LinkedList<Integer> nums, int key) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) < key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public int removeStudents(int[] heights, int n) {
        // code here
        LinkedList<Integer> dp = new LinkedList<>();

        dp.add(heights[0]);

        for (int i = 1; i < n; ++i) {
            if (heights[i] > dp.getLast()) dp.add(heights[i]);
            else {
                int idx = lowerBound(dp, heights[i]);
                dp.set(idx, heights[i]);
            }
        }

        return n - dp.size();
    }
}