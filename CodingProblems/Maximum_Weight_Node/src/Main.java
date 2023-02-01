//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] Edge = new int[N];
            for (int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            int ans = ob.maxWeightCell(N, Edge);
            out.println(ans);
        }
        out.flush();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int maxWeightCell(int n, int[] edge) {
         int[] weight = new int[n];
         int maxWeight = -1;
         int ans = -1;

         for (int i = 0; i < n; ++i) {
             if (edge[i] == -1) continue;
             weight[edge[i]] += i;
             if (maxWeight < weight[edge[i]]) {
                 ans = edge[i];
                 maxWeight = weight[edge[i]];
             }
             else if (maxWeight == weight[edge[i]]) {
                 ans = Math.max(ans, edge[i]);
             }
         }

         return ans;
    }
}