//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String[] S = read.readLine().split(" ");

            int n1 = Integer.parseInt(S[0]);
            int n2 = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            int[] ptr = ob.findSeq(n1, n2, n);

            for(int i=0; i<n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] findSeq(int n1, int n2, int n) {
        // code here
        int[] ans = new int[n];
        HashSet<Integer> visited = new HashSet<>();

        ans[0] = 1;
        visited.add(1);

        for (int i = 1; i < n; ++i) {
            ans[i] = ans[i - 1] + 1;
            for (int j = i - 1; j >= 0; --j) {
                visited.add(n1 * ans[i - 1] - n2 * ans[j]);
                visited.add(n1 * ans[j] - n2 * ans[i - 1]);
            }
            while (visited.contains(ans[i])) ++ans[i];
        }

        return ans;
    }
}