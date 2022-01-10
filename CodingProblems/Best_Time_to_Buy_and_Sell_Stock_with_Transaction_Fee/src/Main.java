import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -1 * prices[0], n = prices.length;

        for (int i = 1; i < n; ++i) {
            int price = prices[i];
            cash = Math.max(cash, hold + price - fee);
            hold = Math.max(hold, cash - price);
        }

        return cash;
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
            int fee = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.maxProfit(prices, fee));
        }

        sc.close();
    }
}
