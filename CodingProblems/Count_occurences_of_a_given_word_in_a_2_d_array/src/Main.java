//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t > 0) {
            int R = sc.nextInt();
            int C = sc.nextInt();

            char[][] mat = new char[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat, target));

            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private int search(char[][] mat, String target, int index, int x, int y) {
        if (index == target.length()) return 1;

        int m = mat.length;
        int n = mat[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || target.charAt(index) != mat[x][y])
            return 0;

        mat[x][y] = '#';
        int ans = 0;

        for (int i = 0; i < 4; ++i) {
            ans += search(mat, target, index + 1, x + dx[i], y + dy[i]);
        }

        mat[x][y] = target.charAt(index);

        return ans;
    }

    public int findOccurrence(char[][] mat, String target) {
        // Write your code here
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == target.charAt(0)) {
                    ans += search(mat, target, 0, i, j);
                }
            }
        }

        return ans;
    }
}