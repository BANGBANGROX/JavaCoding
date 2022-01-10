import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
         int sell = 0;
         int buy = Integer.MIN_VALUE;
         int cool = 0;

         for (int price : prices) {
             int prevSell = sell;
             sell = Math.max(sell, buy + price);
             buy = Math.max(buy, cool - price);
             cool = prevSell;
         }

         return sell;
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
