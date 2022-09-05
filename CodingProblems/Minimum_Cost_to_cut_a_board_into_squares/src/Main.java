//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] P = br.readLine().trim().split(" ");
            int m = Integer.parseInt(P[0]) - 1;
            int n = Integer.parseInt(P[1]) - 1;
            String[] A = br.readLine().trim().split(" ");
            String[] B = br.readLine().trim().split(" ");
            ArrayList<Integer> l = new ArrayList<>();
            for (String s : A) {
                if (s.equals(""))
                    continue;
                l.add(Integer.parseInt(s));
            }
            for (String s : B) {
                if (s.equals(""))
                    continue;
                l.add(Integer.parseInt(s));
            }
            int[] X = new int[m];
            int[] Y = new int[n];
            int ind = 0;
            for (int i = 0; i < m; i++) {
                X[i] = l.get(ind++);
            }
            for (int i = 0; i < n; i++) {
                Y[i] = l.get(ind++);
            }

            Solution obj = new Solution();
            int res = obj.minimumCostOfBreaking(X, Y, m, n);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private void reverse(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            ++l;
            --r;
        }
    }

    public int minimumCostOfBreaking(int[] horizontal, int[] vertical, int m, int n) {
        // code here
        int hPieces = 1;
        int vPieces = 1;
        int ans = 0;
        int i = 0;
        int j = 0;

        Arrays.sort(horizontal);
        Arrays.sort(vertical);
        reverse(horizontal);
        reverse(vertical);

        while (i < m && j < n) {
            if (horizontal[i] < vertical[j]) {
                ans += vertical[j] * hPieces;
                ++vPieces;
                ++j;
            }
            else {
                ans += horizontal[i] * vPieces;
                ++hPieces;
                ++i;
            }
        }

        while (i < m) {
            ans += horizontal[i] * vPieces;
            ++hPieces;
            ++i;
        }

        while (j < n) {
            ans += vertical[j] * hPieces;
            ++vPieces;
            ++j;
        }

        return ans;
    }
}

