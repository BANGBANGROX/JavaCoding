import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        if (n <= 3) return 0;

        Arrays.sort(nums);

        return Math.min(nums[n - 1] - nums[2],
                Math.min(nums[n - 3] - nums[0], nums[n - 2] - nums[1]));
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
            System.out.println(solution.minimizeSum(nums));
        }

        sc.close();
    }
}
