import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n][fuel + 1];

        Arrays.fill(dp[finish], 1);

        for (int currentFuel = 0; currentFuel <= fuel; ++currentFuel) {
            for (int startPos = 0; startPos < n; ++startPos) {
                for (int lastPos = 0; lastPos < n; ++lastPos) {
                    if (startPos == lastPos) continue;
                    int distance = Math.abs(locations[startPos] - locations[lastPos]);
                    if (distance <= currentFuel) {
                        dp[startPos][currentFuel] = (dp[startPos][currentFuel] +
                                dp[lastPos][currentFuel - distance]) % MOD;
                    }
                }
            }
        }

        return (int) dp[start][fuel];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] locations = new int[n];
            for (int i = 0; i < n; ++i) {
                locations[i] = sc.nextInt();
            }
            int start = sc.nextInt();
            int finish = sc.nextInt();
            int fuel = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countRoutes(locations, start, finish, fuel));
        }

        sc.close();
    }
}
