//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());


            int[] p = IntArray.input(br, N);

            Solution obj = new Solution();
            int res = obj.solve(N, p);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int solve(int n, int[] parent) {
        // code here
        int answer = n - 1;
        int[] degree = new int[n];

        for (int i = 1; i < n; ++i) {
            ++degree[parent[i]];
            ++degree[i];
        }

        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) --answer;
        }

        return Math.max(answer, 0);
    }
}

