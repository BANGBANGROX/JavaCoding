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
            String[] inp = read.readLine().split(" ");
            int N = Integer.parseInt(inp[0]);
            int Q = Integer.parseInt(inp[1]);
            String S = read.readLine();
            int[] Q1 = new int[Q];
            int[] Q2 = new int[Q];
            for (int i = 0; i < Q; i++) {
                String[] s = read.readLine().split(" ");
                Q1[i] = Integer.parseInt(s[0]);
                Q2[i] = Integer.parseInt(s[1]);
            }
            Solution ob = new Solution();
            ArrayList<Character> ans = ob.StringQuery(N, Q, S, Q1, Q2);
            for (char u : ans) System.out.println(u);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public ArrayList<Character> StringQuery(int n, int q, String s, int[] q1,
                                            int[] q2) {
        // code here
        ArrayList<Character> ans = new ArrayList<>();
        int rotations = 0;

        for (int i = 0; i < q; ++i) {
            int type = q1[i];
            if (type == 1) {
                int r = q2[i];
                rotations += r;
                rotations %= n;
            }
            else {
                int idx = q2[i];
                ans.add(s.charAt((idx - rotations + n) % n));
            }
        }

        return ans;
    }
}