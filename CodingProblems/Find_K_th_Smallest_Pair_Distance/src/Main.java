import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int upperBound(int[] nums, int l, int r, int key) {
        int ans = nums.length;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] > key) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    private int countLesserOrEqual(int[] nums, int difference) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int num = nums[i] + difference;
            int ind = upperBound(nums, i + 1, n - 1, num);
            count += (ind - i - 1);
        }

        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = nums[1] - nums[0];
        int r = nums[n - 1] - nums[0];

        for (int i = 2; i < n; ++i) {
            l = Math.min(l, nums[i] - nums[i - 1]);
        }

        while (l < r) {
            int mid = (l + ((r - l) >> 1));
            int count = countLesserOrEqual(nums, mid);
            if (count < k) l = mid + 1;
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.smallestDistancePair(nums, k));
        }

        sc.close();
    }
}
