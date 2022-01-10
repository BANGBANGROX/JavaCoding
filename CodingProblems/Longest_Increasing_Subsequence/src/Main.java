import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    private int lowerBound(List<Integer> dp, int key) {
       int l = 0, r = dp.size() - 1;

       while (l < r) {
           int mid = (l + (r - l) / 2);
           if (dp.get(mid) >= key) r = mid;
           else l = mid + 1;
       }

       return l;
    }

    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       List<Integer> dp = new ArrayList<>();

       dp.add(nums[0]);

       for (int i = 1; i < n; ++i) {
           if (nums[i] > dp.get(dp.size() - 1)) dp.add(nums[i]);
           else {
               int index = lowerBound(dp, nums[i]);
               dp.set(index, nums[i]);
           }
       }

       return dp.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) nums[i] = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.lengthOfLIS(nums));
        }

        sc.close();
    }
}
