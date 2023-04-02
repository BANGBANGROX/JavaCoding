//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] mix = new int[n][2];
            int[][] danger = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExplosion(mix, n, danger);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {
    private int[] parent;

    private int find(int node) {
        if (parent[node] == node) return node;

        return parent[node] = find(parent[node]);
    }

    private void union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if (p1 == p2) return;

        parent[p1] = p2;
    }

    public ArrayList<String> avoidExplosion(int[][] mix, int m, int[][] danger) {
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        parent = new int[m];

        for (int i = 0; i < m; ++i) {
            parent[i] = i;
        }

        for (int[] currentMix : mix) {
            int x = currentMix[0] - 1;
            int y = currentMix[1] - 1;
            int px = find(x);
            int py = find(y);
            boolean canMix = true;
            for (int[] currentDanger : danger) {
                int a = currentDanger[0] - 1;
                int b = currentDanger[1] - 1;
                int pa = find(a);
                int pb = find(b);
                if ((px == pa && py == pb) || (px == pb && py == pa)) {
                    canMix = false;
                    break;
                }
            }
            if (canMix) {
                ans.add("Yes");
                union(x, y);
            }
            else {
                ans.add("No");
            }
        }

        return ans;
    }
}
