import java.util.Scanner;

class Solution {
    private long[][] dp;
    private int[] energyDrinkA;
    private int[] energyDrinkB;
    private int n;

    private long maxEnergyBoostHandler(int idx, int currentDrinkNumber) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx][currentDrinkNumber] != -1) {
            return dp[idx][currentDrinkNumber];
        }

        return dp[idx][currentDrinkNumber] = Math.max(maxEnergyBoostHandler(idx + 1, 1 - currentDrinkNumber), maxEnergyBoostHandler(idx + 1, currentDrinkNumber) + (currentDrinkNumber == 0 ? energyDrinkA[idx] : energyDrinkB[idx]));
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        this.energyDrinkA = energyDrinkA;
        this.energyDrinkB = energyDrinkB;
        n = energyDrinkA.length;
        dp = new long[n][2];

        for (int i = 0; i < n; ++i) {
            dp[i][0] = dp[i][1] = -1;
        }

        return Math.max(energyDrinkA[0] + maxEnergyBoostHandler(1, 0), energyDrinkB[0] + maxEnergyBoostHandler(1, 1));
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] energyDrinkA = new int[n];
           for (int i = 0; i < n; ++i) {
               energyDrinkA[i] = scanner.nextInt();
           }
           int[] energyDrinkB = new int[n];
           for (int i = 0; i < n; ++i) {
               energyDrinkB[i] = scanner.nextInt();
           }

           System.out.println(new Solution().maxEnergyBoost(energyDrinkA, energyDrinkB));
       }
   }
}
