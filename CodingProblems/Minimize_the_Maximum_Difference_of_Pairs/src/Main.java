import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int countValidPairs(int[] nums, int threshold) {
        int n = nums.length;
        int cnt = 0;
        int idx = 0;

        while (idx < n - 1) {
            if (nums[idx + 1] - nums[idx] <= threshold) {
                ++cnt;
                ++idx;
            }
            ++idx;
        }

        return cnt;
    }

    public int minimizeMax(int[] nums, int p) {
        int l = 0;
        int r = (int) 1e9 + 5;

        Arrays.sort(nums);

        while (l < r) {
            int mid = (l + ((r - l) >> 1));
            if (countValidPairs(nums, mid) >= p) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
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
            int p = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimizeMax(nums, p));
        }

        sc.close();
    }
}
