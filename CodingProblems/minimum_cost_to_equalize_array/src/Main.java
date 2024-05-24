import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        final int MOD = (int) 1e9 + 7;
        int totalNums = nums.length;

        assert totalNums > 0;

        int ORIGINAL_MAX_ELEMENT = Arrays.stream(nums).max().getAsInt();
        long maxElement = ORIGINAL_MAX_ELEMENT;

        if (2 * cost1 <= cost2 || totalNums <= 2) {
            long answer = 0;
            for (int num : nums) {
                if (num != maxElement) {
                    answer += (long) (maxElement - num) * cost1;
                }
            }

            return (int) (answer % MOD);
        }

        long[] differences = new long[totalNums];

        for (int i = 0; i < totalNums; ++i) {
            differences[i] = maxElement - nums[i];
        }

        Arrays.sort(differences);

        maxElement = differences[totalNums - 1];
        long totalSumExceptLargest = Arrays.stream(differences).sum() - maxElement;
        long answer = Long.MAX_VALUE;

        for (int extra = 0; extra <= 2 * ORIGINAL_MAX_ELEMENT; ++extra) {
            if (extra > 0) {
                totalSumExceptLargest += (totalNums - 1);
                ++maxElement;
            }
            if (maxElement > totalSumExceptLargest) {
                answer = Math.min(answer, cost1 * (maxElement - totalSumExceptLargest) + cost2 * totalSumExceptLargest);
            } else {
                long totalSum = totalSumExceptLargest + maxElement;
                answer = Math.min(answer, totalSum / 2 * cost2 + ((totalSum & 1) > 0 ? cost1 : 0));
            }
        }

        return (int) (answer % MOD);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
