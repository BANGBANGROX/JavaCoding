import java.util.Scanner;

class Solution {
    private boolean check(int[] nums, int target, int len) {
        int sum = 0;
        int l = 0;
        int r = len - 1;
        int n = nums.length;

        for (int i = l; i <= r; ++i) {
            sum += nums[i];
        }

        while (r < n) {
            if (sum >= target) return true;
            sum -= nums[l];
            ++l;
            ++r;
            if (r < n) sum += nums[r];
        }

        return false;
    }

    public int minSubArrayLen(int target, int[] nums) {
         int n = nums.length;
         int l = 1;
         int r = n;
         int ans = 0;

         while (l <= r) {
             int mid = (l + ((r - l) >> 1));
             if (check(nums, target, mid)) {
                 ans = mid;
                 r = mid - 1;
             }
             else l = mid + 1;
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
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minSubArrayLen(target, nums));
        }

        sc.close();
    }
}
