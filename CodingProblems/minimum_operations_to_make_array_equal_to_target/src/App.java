import java.util.Scanner;

class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long answer = 0;
        long previousDiff = 0;
        long sign = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            long currentDiff = target[i] - nums[i];
            if (sign * currentDiff < 0) {
                previousDiff = 0;
            }
            sign = currentDiff;
            currentDiff = Math.abs(currentDiff);
            answer += Math.max(currentDiff - previousDiff, 0);
            previousDiff = currentDiff;
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
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
            }
            int[] target = new int[n];
            for (int i = 0; i < n; ++i) {
                target[i] = scanner.nextInt();
            }

            System.out.println(new Solution().minimumOperations(nums, target));
        }

        scanner.close();
    }
}
