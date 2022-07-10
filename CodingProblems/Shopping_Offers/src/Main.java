import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {
    private final HashMap<List<Integer>, Integer> dp = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
         if (dp.containsKey(needs)) return dp.get(needs);

         int minPrice = 0;
         int n = needs.size();

         for (int i = 0; i < n; ++i) {
             minPrice += needs.get(i) * price.get(i);
         }

         for (List<Integer> offer : special) {
             boolean isPossible = true;
             for (int i = 0; i < n; ++i) {
                 if (offer.get(i) > needs.get(i)) {
                     isPossible = false;
                     break;
                 }
             }
             if (!isPossible) continue;
             for (int i = 0; i < n; ++i) {
                 needs.set(i, needs.get(i) - offer.get(i));
             }
             minPrice = Math.min(minPrice, offer.get(n) + shoppingOffers(price, special, needs));
             for (int i = 0; i < n; ++i) {
                 needs.set(i, needs.get(i) + offer.get(i));
             }
         }

         dp.put(needs, minPrice);

         return minPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<Integer> price = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                price.add(x);
            }
            int m = sc.nextInt();
            List<List<Integer>> special = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                List<Integer> currentOffer = new ArrayList<>();
                for (int j = 0; j <= n; ++j) {
                    int x = sc.nextInt();
                    currentOffer.add(x);
                }
                special.add(new ArrayList<>(currentOffer));
            }
            List<Integer> needs = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                needs.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.shoppingOffers(price, special, needs));
        }

        sc.close();
    }
}
