//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            int[] A = new int[N];
            int[] B = new int[M];

            String[] S1 = read.readLine().split(" ");
            String[] S2 = read.readLine().split(" ");

            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(S2[i]);

            Solution ob = new Solution();
            System.out.println(ob.minInsAndDel(A,B,N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int lowerBound(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) < key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    private boolean search(int[] nums, int key) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] == key) return true;
            else if (nums[mid] > key) r = mid - 1;
            else l = mid + 1;
        }

        return false;
    }

    public int minInsAndDel(int[] nums1, int[] nums2, int m, int n) {
        // code here
        ArrayList<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (search(nums2, nums1[i])) {
                int idx = lowerBound(lis, nums1[i]);
                if (idx >= lis.size()) lis.add(nums1[i]);
                else lis.set(idx, nums1[i]);
            }
        }

        return m + n - 2 * lis.size();
    }
}