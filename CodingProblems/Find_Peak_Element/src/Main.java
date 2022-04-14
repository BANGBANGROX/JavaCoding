import java.util.Scanner;

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        if (n == 1) return 0;

        while (l < r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid;
        }

        return l;
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
            System.out.println(solution.findPeakElement(nums));
        }

        sc.close();
    }
}
