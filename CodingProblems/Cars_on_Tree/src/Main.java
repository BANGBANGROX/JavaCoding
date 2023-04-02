// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //taking testcases
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] starr = str.split(" ");

            //input n and d
            int n = Integer.parseInt(starr[0]);
            int K = Integer.parseInt(starr[1]);

            int[] Par = new int[n];
            String str1 = br.readLine();
            String[] starr1 = str1.split(" ");

            //inserting elements in the array
            for (int j = 0; j < n; j++) {
                Par[j] = Integer.parseInt(starr1[j]);
            }
            long res = Solution.solve(n, K, Par);
            System.out.println(res);
        }
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution {
    private static ArrayList<ArrayList<Integer>> tree;
    private static int[] distance;
    private static long ans;
    private static int k;

    private static void calculateDistance(int node, int parent) {
        int minValue = Integer.MAX_VALUE;

        for (int child : tree.get(node)) {
            if (child != parent) {
                calculateDistance(child, node);
                minValue = Math.min(minValue, distance[child]);
            }
        }

        if (minValue == Integer.MAX_VALUE) return;

        distance[node] = 1 + minValue;
    }

    private static void dfs(int node, int parent, int fuelLeft, long currentTime) {
        if (fuelLeft == 0) {
            currentTime += distance[node];
            fuelLeft = k;
        }

        ans = Math.max(ans, currentTime);

        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node, fuelLeft - 1, currentTime + 1);
            }
        }
    }

    public static long solve(int n, int k, int[] edge) {
        // add your code here
        tree = new ArrayList<>();
        distance = new int[n];
        ans = 0;
        Solution.k = k;
        int root = 0;

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            if (edge[i] == -1) {
                root = i;
            }
            else tree.get(edge[i] - 1).add(i);
        }

        calculateDistance(root, -1);

        dfs(root, -1, k, 0);

        return ans;
    }
}

// { Driver Code Starts.
//Position this line where user code will be pasted.
// Driver Code Ends