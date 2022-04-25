import java.util.Scanner;

class Solution {
    private boolean[] prefix;
    private boolean[] suffix;

    private boolean check(int[] nums, int len) {
        int n = nums.length;
        int l = 0;
        int r = len - 1;

        while (r < n) {
            boolean left = l <= 0 || prefix[l - 1];
            boolean right = r >= n - 1 || suffix[r + 1];
            boolean connect = l == 0 || r == n - 1 || nums[l - 1] <= nums[r + 1];
            if (left && right && connect) return true;
            ++l;
            ++r;
        }

        return false;
    }

    public int findLengthOfShortestSubarray(int[] nums) {
        int n = nums.length;
        prefix = new boolean[n];
        suffix = new boolean[n];

        prefix[0] = true;
        suffix[n - 1] = false;

        for (int i = 1; i < n; ++i) {
            if (nums[i] >= nums[i - 1]) prefix[i] = true;
            else break;
        }

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] <= nums[i + 1]) suffix[i] = true;
            else break;
        }

        if (suffix[0]) return 0;

        int l = 0;
        int r = n;
        int ans = 0;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(nums, mid)) {
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

            Solution solution = new Solution();
            System.out.println(solution.findLengthOfShortestSubarray(nums));
        }

        sc.close();
    }
}
