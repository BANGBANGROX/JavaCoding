import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;

        if (n <= 4) return 0;

        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;

        for (int left = 0, right = n - 4; left < 4; ++left, ++right) {
            answer = Math.min(answer, nums[right] - nums[left]);
        }

        return answer;
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

            System.out.println(new Solution().minDifference(nums));
        }

        scanner.close();
    }
}
