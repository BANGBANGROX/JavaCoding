import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, peak = prices[0], valley = prices[0], ans = 0, i = 0;

        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) ++i;
            valley = prices[i];
            while (i < n - 1 && prices[i] <= prices[i + 1]) ++i;
            peak = prices[i];
            ans += (peak - valley);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; ++i) prices[i] = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.maxProfit(prices));
        }

        sc.close();
    }
}
