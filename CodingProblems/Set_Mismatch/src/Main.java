import java.util.Scanner;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        int n = nums.length;

        for (int num : nums) {
            xor ^= num;
        }

        for (int i = 1; i <= n; ++i) {
            xor ^= i;
        }

        int setBit = xor & -xor;
        int x = 0;
        int y = 0;

        for (int num : nums) {
            if ((num & setBit) > 0) {
                x ^= num;
            }
            else {
                y ^= num;
            }
        }

        for (int i = 1; i <= n; ++i) {
            if ((i & setBit) > 0) {
                x ^= i;
            }
            else {
                y ^= i;
            }
        }

        for (int num : nums) {
            if (num == x) return new int[]{x, y};
        }

        return new int[]{y, x};
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
            int[] ans = solution.findErrorNums(nums);
            System.out.println(ans[0] + " " + ans[1]);
        }

        sc.close();
    }
}
