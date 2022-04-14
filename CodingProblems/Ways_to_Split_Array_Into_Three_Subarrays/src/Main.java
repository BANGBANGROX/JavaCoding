import java.util.Scanner;

class Solution {
    private int splitMid(int start, int key, int[] nums) {
        int n = nums.length;
        int l = start;
        int r = n - 2;
        int ans = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            int sum = nums[mid] - (start == 0 ? 0 : nums[start - 1]);
            if (sum >= key) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    private int splitRight(int start, int key, int[] nums) {
        int n = nums.length;
        int l = start;
        int r = n - 2;
        int ans = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            int sum = nums[mid] - (start == 0 ? 0 : nums[start - 1]);
            if (sum <= key) {
                l = mid + 1;
                ans = mid;
            }
            else r = mid - 1;
        }

        return ans;
    }

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int ans = 0;
        final int mod = (int)1e9 + 7;

        for (int i = 1; i < n; ++i) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < n - 2; ++i) {
            int leftSum = nums[i];
            int remainingSum = nums[n - 1] - leftSum;
            if (nums[n - 1] < leftSum * 3) break;
            int l = splitMid(i + 1, leftSum, nums);
            int r = splitRight(i + 1, remainingSum / 2, nums);
            ans = (ans + (r - l + 1)) % mod;
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
            System.out.println(solution.waysToSplit(nums));
        }

        sc.close();
    }
}
