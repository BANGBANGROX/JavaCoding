import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public long minCost(final int[] basket1, final int[] basket2) {
        final Map<Integer, Integer> totalCount = counter(merge(basket1, basket2));

        for (final int count : totalCount.values()) {
            if ((count & 1) > 0) {
                return -1;
            }
        }

        final Map<Integer, Integer> count1 = counter(basket1);
        final Map<Integer, Integer> count2 = counter(basket2);
        final List<Integer> surplus1 = new ArrayList<>();
        final List<Integer> surplus2 = new ArrayList<>();
        int minFruit = Integer.MAX_VALUE;
        long answer = 0;

        for (final Map.Entry<Integer, Integer> entry : totalCount.entrySet()) {
            final int fruit = entry.getKey();
            final int required = entry.getValue() / 2;

            if (count1.getOrDefault(fruit, 0) > required) {
                final int gap = count1.get(fruit) - required;

                for (int i = 0; i < gap; ++i) {
                    surplus1.add(fruit);
                }
            } else if (count2.getOrDefault(fruit, 0) > required) {
                final int gap = count2.get(fruit) - required;

                for (int i = 0; i < gap; ++i) {
                    surplus2.add(fruit);
                }
            }

            minFruit = Math.min(minFruit, fruit);
        }

        Collections.sort(surplus1);
        surplus2.sort(Comparator.comparingInt(a -> -1 * a));

        for (int i = 0; i < surplus1.size(); ++i) {
            final int first = surplus1.get(i);
            final int second = surplus2.get(i);
            final int cost1 = Math.min(first, second);

            answer += Math.min(cost1, (long) 2 * minFruit);
        }

        return answer;
    }

    private Map<Integer, Integer> counter(final int[] arr) {
        final Map<Integer, Integer> count = new HashMap<>();

        for (final int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    private int[] merge(final int[] arr1, final int[] arr2) {
        final int m = arr1.length;
        final int n = arr2.length;
        final int[] result = new int[m + n];

        System.arraycopy(arr1, 0, result, 0, m);
        System.arraycopy(arr2, 0, result, m, n);

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] basket1 = new int[n];
           for (int i = 0; i < n; ++i) {
               basket1[i] = scanner.nextInt();
           }
           final int[] basket2 = new int[n];
           for (int i = 0; i < n; ++i) {
               basket2[i] = scanner.nextInt();
           }

           System.out.println(new Solution().minCost(basket1, basket2));
       }
       
       scanner.close();
   }
}
