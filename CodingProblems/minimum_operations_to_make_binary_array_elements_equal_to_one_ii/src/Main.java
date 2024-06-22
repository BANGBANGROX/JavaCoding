import java.util.Scanner;

class Solution {
    public int minOperations(int[] nums) {
        int changed = 0;

        for (int num : nums) {
            if ((num == 0 && (changed & 1) == 0) || (num == 1 && (changed & 1) > 0)) {
                ++changed;
            }
        }

        return changed;
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

            System.out.println(new Solution().minOperations(nums));
        }

        sc.close();
    }
}
