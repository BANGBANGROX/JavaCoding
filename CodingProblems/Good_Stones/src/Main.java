//{ Driver Code Starts
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

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());


            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private boolean[] visited;
    private boolean[] recStack;
    private int compSize;

    private boolean checkCycle(int node) {
        visited[node] = true;
        recStack[node] = true;
        ++compSize;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                if (checkCycle(child)) return true;
            }
            else if (recStack[child]) return true;
        }

        recStack[node] = false;

        return false;
    }

    public int goodStones(int n, int[] nums) {
        // code here
        visited = new boolean[n];
        recStack = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            if (i + nums[i] >= n || i + nums[i] < 0) continue;
            graph.get(i).add(i + nums[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                compSize = 0;
                if (!checkCycle(i)) {
                    ans += compSize;
                }
            }
        }

        return ans;
    }
}

