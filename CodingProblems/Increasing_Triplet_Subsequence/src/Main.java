import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private int lowerBound(ArrayList<Integer> nums, int key) {
        int n = nums.size();
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) < key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public boolean increasingTriplet(int[] nums) {
         ArrayList<Integer> dp = new ArrayList<>();
         int n = nums.length;

         dp.add(nums[0]);

         for (int i = 1; i < n; ++i) {
             if (dp.get(dp.size() - 1) < nums[i]) dp.add(nums[i]);
             else {
                 int idx = lowerBound(dp, nums[i]);
                 dp.set(idx, nums[i]);
             }
             if (dp.size() == 3) return true;
         }

         return false;
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
            System.out.println(solution.increasingTriplet(nums));
        }

        sc.close();
    }
}
