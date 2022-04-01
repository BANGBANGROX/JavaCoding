import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private boolean check(int[] nums, int sum, int m) {
        int splits = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= sum) {
                currentSum += num;
            }
            else {
                ++splits;
                currentSum = num;
                if (splits > m) return false;
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int m) {
         int l = Arrays.stream(nums).max().getAsInt();
         int r = Arrays.stream(nums).sum();
         int ans = -1;

         while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(nums, mid, m)) {
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
            int m = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.print(solution.splitArray(nums, m));
        }

        sc.close();
    }
}
