import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         int n = nums.length;

         for (int mask = 0; mask < (1 << n); ++mask) {
             List<Integer> currentSubset = new ArrayList<>();
             for (int i = 0; i < n; ++i) {
                 if ((mask & (1 << i)) > 0) {
                     currentSubset.add(nums[i]);
                 }

             }
             ans.add(new ArrayList<>(currentSubset));
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
            System.out.println(solution.subsets(nums));
        }

        sc.close();
    }
}
