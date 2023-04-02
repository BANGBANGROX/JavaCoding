//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix {
    public static int[][] input(BufferedReader br, int n) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
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


            int num;
            num = Integer.parseInt(br.readLine());


            int[] A = IntArray.input(br, N);


            int[][] Q = IntMatrix.input(br, num);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.solveQueries(N, num, A, Q);

            IntArray.print(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> solveQueries(int n, int q, int[] nums, int[][] queries) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, int[]> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, new int[n]);
        }

        count.get(nums[n - 1])[n - 1] = 1;

        for (int i = n - 2; i >= 0; --i) {
            count.get(nums[i])[i] = count.get(nums[i])[i + 1] + 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] != nums[i]) {
                    count.get(nums[j])[i] = count.get(nums[j])[i + 1];
                }
            }
        }

        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int cnt = 0;
            for (int j = l; j <= r; ++j) {
                if (count.get(nums[j])[j] == k) ++cnt;
            }
            ans.add(cnt);
        }

        return ans;
    }
}

