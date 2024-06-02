import java.util.Scanner;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            int currentAnd = nums[i];
            for (int j = i; j < n; ++j) {
                currentAnd &= nums[j];
                answer = Math.min(answer, Math.abs(k - currentAnd));
                if (currentAnd <= k || currentAnd <= dp[j]) {
                    break;
                }
                dp[j] = currentAnd;
            }
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

            System.out.println(new Solution().minimumDifference(nums, k));
        }

        sc.close();
    }
}
