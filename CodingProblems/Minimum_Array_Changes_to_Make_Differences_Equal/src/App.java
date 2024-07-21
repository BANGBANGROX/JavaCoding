import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int minChanges(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int[] prefixSum = new int[k + 1];
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        int runningSum = 0;

        for (int i = 0; i < n / 2; ++i) {
            int difference = Math.abs(nums[i] - nums[n - i - 1]);
            count.put(difference, count.getOrDefault(difference, 0) + 1);
            int maxDiff = Math.max(Math.max(nums[i], nums[n - i - 1]), Math.max(k - nums[i], k - nums[n - i - 1]));
            ++prefixSum[0];
            if (maxDiff + 1 <= k) {
                ++prefixSum[maxDiff + 1];
            }
        }

        for (int i = 0; i <= k; ++i) {
            runningSum += prefixSum[i];
            answer = Math.min(answer, runningSum - count.getOrDefault(i, 0));
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            assert n % 2 == 0;
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();

            System.out.println(new Solution().minChanges(nums, k));
        }

        scanner.close();
    }
}
