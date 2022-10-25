//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.getSum(x, y, z));
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

class Solution {
    public int getSum(int x, int y, int z) {
        // Your code goes here
        final int MOD = (int) 1e9 + 7;
        long[][][] exactSum = new long[x + 1][y + 1][z + 1];
        long[][][] exactNum = new long[x + 1][y + 1][z + 1];
        long ans = 0;

        exactNum[0][0][0] = 1;

        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                for (int k = 0; k <= z; ++k) {
                    if (i > 0) {
                        exactSum[i][j][k] = (exactSum[i][j][k] +
                                exactSum[i - 1][j][k] * 10 +
                                4 * exactNum[i - 1][j][k]) % MOD;
                        exactNum[i][j][k] = (exactNum[i][j][k] +
                                exactNum[i - 1][j][k]) % MOD;
                    }
                    if (j > 0) {
                        exactSum[i][j][k] = (exactSum[i][j][k] +
                                exactSum[i][j - 1][k] * 10 +
                                5 * exactNum[i][j - 1][k]) % MOD;
                        exactNum[i][j][k] = (exactNum[i][j][k] +
                                exactNum[i][j - 1][k]) % MOD;
                    }
                    if (k > 0) {
                        exactSum[i][j][k] = (exactSum[i][j][k] + exactSum[i][j][k - 1] * 10 +
                                6 * exactNum[i][j][k - 1]) % MOD;
                        exactNum[i][j][k] = (exactNum[i][j][k] +
                                exactNum[i][j][k - 1]) % MOD;
                    }
                    ans = (ans + exactSum[i][j][k]) % MOD;
                }
            }
        }

        return (int) ans;
    }
}