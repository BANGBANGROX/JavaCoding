//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] A = new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int[] B = new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public long maxPossibleValue(int n, int[] length, int[] sideCount) {
        // code here
        long ans = 0;
        long totalCount = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            int cnt = sideCount[i] / 2;
            ans += (2L * cnt * length[i]);
            if (cnt > 0) {
                minValue = Math.min(minValue, length[i]);
            }
            totalCount += cnt;
        }

        if ((totalCount & 1) > 0) {
            ans -= 2L * minValue;
        }

        return ans;
    }
}