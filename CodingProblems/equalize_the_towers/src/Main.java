import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] heights;
    private int[] cost;

    public int minCost(final int[] heights, final int[] cost) {
        // code here
        this.heights = heights;
        this.cost = cost;
        int left = Arrays.stream(heights).min().getAsInt();
        int right = Arrays.stream(heights).max().getAsInt();

        while (left < right) {
            final int mid1 = left + (right - left) / 3;
            final int mid2 = right - (right - left) / 3;
            if (findCost(mid1) < findCost(mid2)) {
                right = mid2 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return findCost(left);
    }

    private int findCost(final int requiredHeight) {
        int totalCost = 0;
        final int n = heights.length;

        for (int i = 0; i < n; ++i) {
            totalCost += Math.abs(heights[i] - requiredHeight) * cost[i];
        }

        return totalCost;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] heights = new int[n];
           final int[] cost = new int[n];
           for (int i = 0; i < n; ++i) {
               heights[i] = scanner.nextInt();
           }
           for (int i = 0; i < n; ++i) {
               cost[i] = scanner.nextInt();
           }

           System.out.println(new Solution().minCost(heights, cost));
       }
       
       scanner.close();
   }
}
