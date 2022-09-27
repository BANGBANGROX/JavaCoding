import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] overlaps = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                int m = Math.min(words[i].length(), words[j].length());
                for (int k = m; k >= 0; --k) {
                    if (words[i].endsWith(words[j].substring(0, k))) {
                        overlaps[i][j] = k;
                        break;
                    }
                }
            }
        }

        int fullMask = (1 << n) - 1;
        int[][] dp = new int[fullMask + 1][n];
        int[][] parent = new int[fullMask + 1][n];

        for (int mask = 0; mask <= fullMask; ++mask) {
            Arrays.fill(parent[mask], -1);
            for (int bit = 0; bit < n; ++bit) {
                if (((mask >> bit) & 1) > 0) {
                    int pMask = mask ^ (1 << bit);
                    if (pMask == 0) continue;
                    for (int i = 0; i < n; ++i) {
                        if (((pMask >> i) & 1) > 0) {
                            int val = dp[pMask][i] + overlaps[i][bit];
                            if (dp[mask][bit] < val) {
                                dp[mask][bit] = val;
                                parent[mask][bit] = i;
                            }
                        }
                    }
                }
            }
        }

        int[] perm = new int[n];
        boolean[] seen = new boolean[n];
        int p = 0;
        int t = 0;
        int mask = fullMask;

        for (int i = 0; i < n; ++i) {
            if (dp[fullMask][i] > dp[fullMask][p]) p = i;
        }

        while (p != -1) {
            perm[t] = p;
            seen[p] = true;
            ++t;
            int p2 = parent[mask][p];
            mask ^= (1 << p);
            p = p2;
        }

        int l = 0;
        int r = t - 1;

        while (l < r) {
            int temp = perm[l];
            perm[l] = perm[r];
            perm[r] = temp;
            ++l;
            --r;
        }

        for (int i = 0; i < n; ++i) {
            if (!seen[i]) {
                perm[t] = i;
                ++t;
            }
        }

        StringBuilder ans = new StringBuilder(words[perm[0]]);

        for (int i = 1; i < n; ++i) {
            int overlap = overlaps[perm[i - 1]][perm[i]];
            ans.append(words[perm[i]].substring(overlap));
        }

        return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) {
                words[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.shortestSuperstring(words));
        }

        sc.close();
    }
}
