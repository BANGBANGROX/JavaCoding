import java.util.Scanner;

class Solution {
    public int maxProfit(int k, int[] prices) {
         int[] minPrices = new int[k];
         int[] profit = new int[k];

         if (k == 0) return 0;

         for (int i = 0; i < k; ++i) minPrices[i] = Integer.MAX_VALUE;

         for (int price : prices) {
             minPrices[0] = Math.min(minPrices[0], price);
             profit[0] = Math.max(profit[0], price - minPrices[0]);
             for (int i = 1; i < k; ++i) {
                 minPrices[i] = Math.min(minPrices[i], price - profit[i - 1]);
                 profit[i] = Math.max(profit[i], price - minPrices[i]);
             }
         }

         return profit[k - 1];
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
            int k = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.maxProfit(k, prices));
        }

        sc.close();
    }
}
