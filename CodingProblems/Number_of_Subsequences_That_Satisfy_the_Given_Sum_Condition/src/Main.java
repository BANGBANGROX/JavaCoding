import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private final int mod = (int)1e9 + 7;

    private int upperBound(int[] nums, int key) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int ans = n;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] <= key) l = mid + 1;
            else {
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
    }

    private int binExponent(long a, long b) {
         long res = 1;

         while (b > 0) {
             if ((b & 1) > 0) {
                 res = ((res % mod) * (a % mod)) % mod;
                 --b;
             }
             a = ((a % mod) * (a % mod)) % mod;
             b /= 2;
         }

         return (int)res;
    }

    public int numSubseq(int[] nums, int target) {
        long ans = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            int key = target - nums[i];
            if (nums[i] * 2 <= target) {
                ans = (ans + 1) % mod;
            }
            int idx = upperBound(nums, key);
            if (idx == n || nums[idx] != key) --idx;
            if (idx < i) continue;
            ans = (ans + binExponent(2, idx - i)) % mod;
        }

        return (int)ans;
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
            System.out.println(solution.numSubseq(nums, target));
        }

        sc.close();
    }
}
