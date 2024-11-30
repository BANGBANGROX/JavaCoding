import java.util.Scanner;
import java.util.Arrays;

class Solution {
    private int[] nums;
    private int[][][] dp;
    private int[][] gcdArray;

    private int calculateGCD(int a, int b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    private int subsequencePairCountHandler(int gcdS1, int gcdS2, int i) {
        if (i == nums.length) {
            if (gcdS1 == 0 || gcdS2 == 0) return 0;
            return gcdS1 == gcdS2 ? 1 : 0;
        }

        if (dp[gcdS1][gcdS2][i] != -1) return dp[gcdS1][gcdS2][i];

        final int MOD = (int) 1e9 + 7;
        long result = subsequencePairCountHandler(gcdS1, gcdS2, i + 1);
        result = (result + subsequencePairCountHandler(gcdArray[gcdS1][nums[i]], gcdS2,
                i + 1));
        result = (result + subsequencePairCountHandler(gcdS1, gcdArray[gcdS2][nums[i]],
                i + 1)) % MOD;

        return dp[gcdS1][gcdS2][i] = (int) result;
    }

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        dp = new int[maxValue + 1][maxValue + 1][nums.length];
        gcdArray = new int[maxValue + 1][maxValue + 1];

        for (int i = 1; i <= maxValue; ++i) {
            for (int j = 1; j <= maxValue; ++j) {
                gcdArray[i][j] = calculateGCD(i, j);
            }
        }

        for (int i = 0; i <= maxValue; ++i) {
            gcdArray[0][i] = i;
            gcdArray[i][0] = i;
        }

        for (int[][] current : dp) {
            for (int[] row : current) {
                Arrays.fill(row, -1);
            }
        }

        return subsequencePairCountHandler(0, 0, 0);
    }
}


public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().subsequencePairCount(nums));
       }
       
       scanner.close();
   }
}
