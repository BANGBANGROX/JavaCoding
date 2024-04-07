import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        int middleIndex = ((n & 1) > 0) ? n / 2 : (n + 1) / 2;
        long answer = 0;

        Arrays.sort(nums);

        // First half
        for (int i = 0; i < middleIndex; ++i) {
            if (nums[i] <= k) continue;
            answer += (nums[i] - k);
        }

        // Middle
        answer += Math.abs(nums[middleIndex] - k);

        // Second half
        for (int i = middleIndex + 1; i < n; ++i) {
            if (nums[i] >= k) continue;
            answer += (k - nums[i]);
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minOperationsToMakeMedianK(nums, k));
        }

        sc.close();
    }
}
