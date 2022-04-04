import java.util.Scanner;

class Solution {
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int x = nums[l];
            nums[l] = nums[r];
            nums[r] = x;
            ++l;
            --r;
        }
    }

    private boolean nextPermutationUtil(int[] nums) {
         int n = nums.length;

         if (n == 1) return false;

         int last = n - 2;

         while (last >= 0 && nums[last] >= nums[last + 1]) --last;

         if (last < 0) return false;

         int nextGreater = n - 1;

         for (int i = n - 1; i > last; --i) {
             if (nums[last] < nums[i]) {
                 nextGreater = i;
                 break;
             }
         }

         int temp = nums[last];
         nums[last] = nums[nextGreater];
         nums[nextGreater] = temp;

         int l = last + 1;
         int r = n - 1;

         reverse(nums, l, r);

         return true;
    }

    public void nextPermutation(int[] nums) {
          if (!nextPermutationUtil(nums)) {
                reverse(nums, 0, nums.length - 1);
          }
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
            solution.nextPermutation(nums);
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
