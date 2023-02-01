import java.util.Scanner;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainders = new int[k];
        int n = nums.length;
        int ans = 0;

        for (int i = 1; i < n; ++i) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                int x = -1 * nums[i] / k + 1;
                nums[i] += x * k;
            }
            ++remainders[nums[i] % k];
        }

        ans += remainders[0];
        ans += (remainders[0] * (remainders[0] - 1)) / 2;

        for (int i = 1; i < k; ++i) {
            ans += remainders[i] * (remainders[i] - 1) / 2;
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.subarraysDivByK(nums, k));
        }

        sc.close();
    }
}
