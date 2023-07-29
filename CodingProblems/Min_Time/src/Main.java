//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new Main(), "whatever", 1 << 26).start();
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);

            int t = Integer.parseInt(in.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());
                int[] A = new int[n], B = new int[n];
                String[] s = in.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) {
                    A[i] = Integer.parseInt(s[i]);
                }
                s = in.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) {
                    B[i] = Integer.parseInt(s[i]);
                }
                Solution ob = new Solution();
                long ans = ob.minTime(n, A, B);
                out.println(ans);
            }
            out.close();
        } catch (IOException ignored) {
        }
    }
}
// } Driver Code Ends


class Solution {
    private long[][] data;
    private long[][] dp;
    private int len;

    private long minTimeHandler(int index, int flag) {
        if (index == len) return data[index - 1][flag];

        if (dp[index][flag] != -1) return dp[index][flag];

        long result = minTimeHandler(index + 1, 1 - flag) +
                Math.abs(data[index - 1][flag] - data[index][flag]);

        result = Math.min(result, minTimeHandler(index + 1, flag) +
                Math.abs(data[index - 1][flag] - data[index][1 - flag]));

        return dp[index][flag] = result + data[index][1] - data[index][0];
    }

    public long minTime(int n, int[] locations, int[] types) {
        // code here
        data = new long[n + 1][2];
        dp = new long[n + 1][2];
        len = n + 1;
        TreeMap<Integer, long[]> treeMap = new TreeMap<>();

        for (int i = 0; i < n; ++i) {
            if (!treeMap.containsKey(types[i])) {
                treeMap.put(types[i], new long[]{locations[i], locations[i]});
            }
            else {
                long[] current = treeMap.get(types[i]);
                long[] next = {Math.min(current[0], locations[i]),
                        Math.max(current[1], locations[i])};
                treeMap.put(types[i], next);
            }
        }

        data[0] = new long[]{0, 0};
        int idx = 1;

        for (int key : treeMap.keySet()) {
            data[idx] = treeMap.get(key);
            ++idx;
        }

        for (int i = 0; i < n + 1; ++i) {
            dp[i][0] = dp[i][1] = -1;
        }

        return minTimeHandler(1, 0);
    }
}

