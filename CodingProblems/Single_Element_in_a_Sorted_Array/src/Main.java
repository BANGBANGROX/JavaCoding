import java.util.Scanner;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (mid == 0 || mid == n - 1 || (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]))
                return nums[mid];
            int rightGap = nums[mid] == nums[mid + 1] ? n - mid - 2 : n - mid - 1;
            if ((rightGap & 1) > 0) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
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
            System.out.println(solution.singleNonDuplicate(nums));
        }

        sc.close();
    }
}
