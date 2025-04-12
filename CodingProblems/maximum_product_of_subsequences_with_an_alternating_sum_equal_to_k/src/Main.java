import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Solution {
    private int[] nums;
    private Map<Key, Integer> dp;
    private int limit;
    private int k;
    private int n;

    private static class Key {
        int idx;
        int currentSum;
        int currentProduct;
        int parity;

        public Key(int idx, int currentSum, int currentProduct, int parity) {
            this.idx = idx;
            this.currentSum = currentSum;
            this.currentProduct = currentProduct;
            this.parity = parity;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Key k)) {
                return false;
            }

            return k.idx == this.idx && k.currentSum == this.currentSum && k.currentProduct == this.currentProduct && k.parity == this.parity;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx, currentSum, currentProduct, parity);
        }
    }

    private int maxProductHandler(int idx, int currentSum,
                                  int currentProduct, int parity) {
        if (idx == n) {
            if (currentSum == k && currentProduct <= limit && parity > 0) return currentProduct;
            return Integer.MIN_VALUE;
        }

        Key key = new Key(idx, currentSum, currentProduct, parity);

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int result = maxProductHandler(idx + 1, currentSum, currentProduct, parity);
        int newProduct = Math.min(currentProduct * nums[idx], limit + 1);

        if (parity == 0 || parity == 2) {
            result = Math.max(result, maxProductHandler(idx + 1, currentSum + nums[idx], newProduct, 1));
        } else if (parity == 1) {
            result = Math.max(result, maxProductHandler(idx + 1, currentSum - nums[idx], newProduct, 2));
        }

        dp.put(key, result);

        return result;
    }

    public int maxProduct(int[] nums, int k, int limit) {
        int totalSum = Arrays.stream(nums).sum();

        if (Math.abs(k) > totalSum) return -1;

        this.nums = nums;
        this.k = k;
        this.limit = limit;
        n = nums.length;
        dp = new HashMap<>();
        int answer = maxProductHandler(0, 0, 1, 0);

        return answer == Integer.MIN_VALUE ? -1 : answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           int k = scanner.nextInt();
           int limit = scanner.nextInt();

           System.out.println(new Solution().maxProduct(nums, k, limit));
       }
       
       scanner.close();
   }
}
