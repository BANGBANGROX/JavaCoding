//{ Driver Code Starts
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG gfg = new GfG();
            int Q = sc.nextInt();


            int[] st = gfg.constructST(arr, n);
            int l, r;
            for (int i = 0; i < Q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a, b);
                r = Math.max(a, b);

                System.out.print(gfg.RMQ(st, n, l, r) + " ");

            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG {
    private int[] tree;

    private void constructSTUtil(int[] nums, int start, int end, int idx) {
        if (start == end) {
            tree[idx] = nums[start];
            return;
        }

        int mid = (start + ((end - start) >> 1));

        constructSTUtil(nums, start, mid, 2 * idx + 1);
        constructSTUtil(nums, mid + 1, end, 2 * idx + 2);

        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    private int queryUtil(int idx, int start, int end, int l, int r) {
        if (start > r || end < l) return Integer.MAX_VALUE;

        if (start >= l && end <= r) return tree[idx];

        int mid = (start + ((end - start) >> 1));
        int left = queryUtil(2 * idx + 1, start, mid, l, r);
        int right = queryUtil(2 * idx + 2, mid + 1, end, l, r);

        return Math.min(left, right);
    }


    public int[] constructST(int[] nums, int n) {
        // Add your code here
        tree = new int[4 * n];

        constructSTUtil(nums, 0, n - 1, 1);

        return tree;
    }


    /* The function returns the
      min element in the range
      from l and r */
    public int RMQ(int[] st, int n, int l, int r) {
        // Add your code here
        return queryUtil(1, 0, n - 1, l, r);
    }
}