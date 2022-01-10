import java.util.Scanner;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int maxLen = 1;
        int prevDiff = 0;

        for (int i = 1; i < n; ++i) {
            int currDiff = nums[i] - nums[i - 1];
            if ((prevDiff >= 0 && currDiff < 0) || (prevDiff <= 0 && currDiff > 0)) {
                prevDiff = currDiff;
                ++maxLen;
            }
        }

        return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) nums[i] = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.wiggleMaxLength(nums));
        }

        sc.close();
    }
}
