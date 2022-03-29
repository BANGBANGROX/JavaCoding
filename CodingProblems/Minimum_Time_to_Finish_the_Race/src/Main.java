import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
         int[] initialTime = new int[19];
         int maxTime = (int)Math.pow(2, 17);
         int[] dp = new int[numLaps + 1];
        Arrays.fill(initialTime, Integer.MAX_VALUE);

         for (int[] tire : tires) {
             int f = tire[0];
             int r = tire[1];
             int totalTime = 0;
             for (int i = 1; i <= numLaps; ++i) {
                 if (f >= maxTime / (int)Math.pow(r, i - 1)) break;
                 int currentTime = f * (int)Math.pow(r, i - 1);
                 totalTime += currentTime;
                 if (totalTime > maxTime) break;
                 initialTime[i] = Math.min(initialTime[i], totalTime);
             }
         }

         for (int i = 1; i <= numLaps; ++i) {
             dp[i] = (i < 19) ? initialTime[i] : Integer.MAX_VALUE;
             for (int j = 1; j < i; ++j) {
                 dp[i] = Math.min(dp[i], dp[i - j] + dp[j] + changeTime);
             }
         }

         return dp[numLaps];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] tires = new int[n][2];
            for (int i = 0; i < n; ++i) {
                tires[i][0] = sc.nextInt();
                tires[i][1] = sc.nextInt();
            }
            int changeTime = sc.nextInt();
            int numLaps = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumFinishTime(tires, changeTime, numLaps));
        }

        sc.close();
    }
}
