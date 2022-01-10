import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, maxProfit = 0, minPrice = prices[0];

        for (int i = 1; i < n; ++i) {
            if (prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
            else {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; ++i) {
                prices[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            System.out.println(obj.maxProfit(prices));
        }

        sc.close();
    }
}
