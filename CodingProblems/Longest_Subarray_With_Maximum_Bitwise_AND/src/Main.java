import java.util.Scanner;

class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int maxAnd = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int cnt = 1;
            int num = nums[i];
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                ++cnt;
                ++i;
            }
            if (num >= maxAnd) {
                if (num == maxAnd) ans = Math.max(ans, cnt);
                else ans = cnt;
                maxAnd = num;
            }
        }

        return ans;
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

            Solution solution = new Solution();
            System.out.println(solution.longestSubarray(nums));
        }

        sc.close();
    }
}
