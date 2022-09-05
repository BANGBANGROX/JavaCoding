import java.util.Scanner;

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int used = 0;
        int j = 0;
        int ans = 1;

        for (int i = 0; i < nums.length; ++i) {
            while ((nums[i] & used) != 0) {
                used ^= nums[j];
                ++j;
            }
            used |= nums[i];
            ans = Math.max(ans, i - j + 1);
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
            System.out.println(solution.longestNiceSubarray(nums));
        }

        sc.close();
    }
}
