import java.util.Scanner;

class Solution {
    public int findLatestStep(int[] nums, int m) {
        int n = nums.length;
        int ans = -1;
        int count = 0;
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];

        for (int i = 0; i < n; ++i) {
            int idx = nums[i];
            int l = left[idx - 1];
            int r = right[idx + 1];
            if (l == m) --count;
            if (r == m) --count;
            if ((l + r + 1) == m) ++count;
            right[idx - l] = r + l + 1;
            left[idx + r] = r + l + 1;
            if (count > 0) ans = i + 1;
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
            int m = sc.nextInt();

            Solution solution = new Solution();
            System.out.print(solution.findLatestStep(nums, m));
        }

        sc.close();
    }
}
