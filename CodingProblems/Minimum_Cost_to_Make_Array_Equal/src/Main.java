import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long totalCost = 0;
        long[] prefixCost = new long[n];
        int[][] numsAndCost = new int[n][2];

        for (int i = 0; i < n; ++i) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }

        Arrays.sort(numsAndCost, Comparator.comparingInt(a -> a[0]));
        prefixCost[0] = numsAndCost[0][1];

        for (int i = 1; i < n; ++i) {
            prefixCost[i] = prefixCost[i - 1] + numsAndCost[i][1];
        }

        for (int i = 1; i < n; ++i) {
            totalCost += (long) numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
        }

        long answer = totalCost;

        for (int i = 1; i < n; ++i) {
            int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
            totalCost += prefixCost[i - 1] * gap;
            totalCost -= (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
            answer = Math.min(answer, totalCost);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int[] cost = new int[n];
            for (int i = 0; i < n; ++i) {
                cost[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.minCost(nums, cost));
        }

        sc.close();
    }
}
