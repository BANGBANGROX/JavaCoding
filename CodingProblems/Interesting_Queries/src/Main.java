//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int q = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int[] nums = new int[n];
            String[] S1 = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S1[i]);
            int[][] Queries = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] S3 = br.readLine().trim().split(" ");
                for(int j = 0; j < S3.length; j++){
                    Queries[i][j] = Integer.parseInt(S3[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.solveQueries(nums, Queries, k);
            for (int an : ans) System.out.println(an);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class Node {
        int val;
        int pos;
        int l;
        int r;

        Node(int val, int pos, int l, int r) {
            this.val = val;
            this.pos = pos;
            this.l = l;
            this.r = r;
        }
    }

    private void update(int[] binaryIndexedTree, int n, int idx) {
        while (idx <= n) {
            ++binaryIndexedTree[idx];
            idx += (idx & (-1 * idx));
        }
    }

    private int query(int[] binaryIndexedTree, int idx) {
        int res = 0;

        while (idx > 0) {
            res += binaryIndexedTree[idx];
            idx -= (idx & (-1 * idx));
        }

        return res;
    }

    public int[] solveQueries(int[] nums, int[][] queries, int k) {
        // Code here
        int n = nums.length;
        int q = queries.length;
        Node[] nodes = new Node[n + q + 1];
        int[] ans = new int[q];
        int[] binaryIndexedTree = new int[n + 1];

        nodes[0] = new Node(0, 0, 0, 0);

        for (int i = 1; i <= n; ++i) {
            nodes[i] = new Node(nums[i - 1], 0, 0, i);
        }

        for (int i = n + 1; i <= n + q; ++i) {
            nodes[i] = new Node(k, i - n, queries[i - n - 1][0], queries[i - n - 1][1]);
        }

        Arrays.sort(nodes, (a, b) -> a.val != b.val ? b.val - a.val : b.l - a.l);

        for (int i = 1; i <= n + q; ++i) {
            if (nodes[i].pos == 0) {
                update(binaryIndexedTree, n, nodes[i].r);
            }
            else {
                int result = query(binaryIndexedTree, nodes[i].r) -
                        query(binaryIndexedTree, nodes[i].l - 1);
                ans[nodes[i].pos - 1] = result;
            }
        }

        return ans;
    }
}