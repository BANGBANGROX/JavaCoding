//{ Driver Code Starts
import javax.swing.*;
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int N;
            N = Integer.parseInt(br.readLine());


            int[] A = IntArray.input(br, N);


            int[] P = IntArray.input(br, N);

            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private ArrayList<ArrayList<Integer>> tree;
    private int[] value;
    private long ans;

    private long dfs(int node, boolean flag) {
        long maxValue = Long.MIN_VALUE;

        for (int child : tree.get(node)) {
            maxValue = Math.max(maxValue, dfs(child, !flag));
        }

        if (flag) value[node] *= -1;

        if (maxValue == Long.MIN_VALUE) return value[node];

        long result = (maxValue == Long.MAX_VALUE ? value[node] :
                value[node] + maxValue);

        ans = Math.max(ans, result);

        return result;
    }

    public long bestNode(int n, int[] value, int[] parent) {
        // code here
        tree = new ArrayList<>();
        this.value = value;

        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            if (parent[i] == -1) continue;
            tree.get(parent[i] - 1).add(i);
        }

        ans = Long.MIN_VALUE;
        dfs(0, false);

        return ans;
    }
}

