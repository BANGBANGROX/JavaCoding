// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] price = new int[n][2];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                price[i][0] = Integer.parseInt(s[0]);
                price[i][1] = Integer.parseInt(s[1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            int q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[q][2];
            for(int i = 0; i < q; i++){
                s = br.readLine().trim().split(" ");
                queries[i][0] = Integer.parseInt(s[0]);
                queries[i][1] = Integer.parseInt(s[1]);
            }
            int[] answer = new Solution().bestPrice(n,price,k,q,queries);
            for(int x : answer)
                ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private int lowerBound(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) == key) return mid;
            if (nums.get(mid) < key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public int[] bestPrice(int n, int[][] price, int k, int q, int[][] queries) {
        int maxPrice = 0;
        ArrayList<Integer> pricesInRange = new ArrayList<>();
        int[] ans = new int[q];

        for (int[] p : price) {
            maxPrice = Math.max(maxPrice, p[1]);
        }

        int[] pref = new int[maxPrice + 2];

        for (int i = 0; i < n; ++i) {
            int[] p = price[i];
            ++pref[p[0]];
            --pref[p[1] + 1];
        }

        for (int i = 1; i <= maxPrice; ++i) {
            pref[i] += pref[i - 1];
            if (pref[i] >= k) {
                pricesInRange.add(i);
            }
        }

        if (pricesInRange.isEmpty()) return ans;

        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            int idx1 = lowerBound(pricesInRange, l);
            int idx2 = lowerBound(pricesInRange, r);
            if (idx2 == pricesInRange.size() || pricesInRange.get(idx2) > r) {
                --idx2;
            }
            ans[i] = (idx2 - idx1 + 1);
        }

        return ans;
    }
}