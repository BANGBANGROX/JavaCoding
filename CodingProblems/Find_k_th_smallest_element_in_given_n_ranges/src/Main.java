//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int[][] range = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().trim().split(" ");
                range[i][0] = Integer.parseInt(s[0]);
                range[i][1] = Integer.parseInt(s[1]);
            }
            int q = Integer.parseInt(in.readLine().trim());
            int[] Q = new int[q];
            String[] s = in.readLine().trim().split(" ");
            for (int i = 0; i < q; i++) {
                Q[i] = Integer.parseInt(s[i]);
            }

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.kthSmallestNum(n, range, q, Q);

            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    private int[][] getNonOverlappingIntervals(int[][] range, int n) {
        LinkedList<int[]> result = new LinkedList<>();
        int maxR = range[0][1];

        Arrays.sort(range, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        result.add(new int[]{range[0][0], range[0][1]});

        for (int i = 1; i < n; ++i) {
            int l = range[i][0];
            int r = range[i][1];
            int[] lastRange = result.getLast();
            if (l > lastRange[1]) {
                result.add(new int[]{l, r});
            }
            else {
                result.pollLast();
                result.add(new int[]{lastRange[0], Math.max(r, lastRange[1])});
                maxR = Math.max(r, maxR);
            }
        }

        int[][] answer = new int[result.size()][];

        for (int i = 0; i < result.size(); ++i) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        int[][] nonOverlappingIntervals = getNonOverlappingIntervals(range, n);
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < q; ++i) {
            int k = queries[i];
            boolean found = false;
            for (int[] currentRange : nonOverlappingIntervals) {
                int l = currentRange[0];
                int r = currentRange[1];
                int cnt = (r - l + 1);
                if (cnt < k) {
                    k -= cnt;
                }
                else {
                    answer.add(l + k - 1);
                    found = true;
                    break;
                }
            }
            if (!found) answer.add(-1);
        }

        return answer;
    }
}

