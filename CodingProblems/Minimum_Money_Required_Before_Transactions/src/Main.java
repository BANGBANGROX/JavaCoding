import java.util.Scanner;

class Solution {
    public long minimumMoney(int[][] transactions) {
        long ans = 0;
        int maxValue = 0;

        for (int[] transaction: transactions) {
            ans += Math.max(0, transaction[0] - transaction[1]);
            maxValue = Math.max(maxValue, Math.min(transaction[0], transaction[1]));
        }

        return ans + maxValue;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] transactions = new int[n][2];
            for (int i = 0; i < n; ++i) {
                transactions[i][0] = sc.nextInt();
                transactions[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.minimumMoney(transactions));
        }

        sc.close();
    }
}
