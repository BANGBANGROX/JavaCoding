import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
       int n = nums.length;
       int[] prefix = new int[n];
       int[] suffix = new int[n];
       List<Integer> ans = new ArrayList<>();

       prefix[0] = suffix[n - 1] = 1;

       for (int i = 1; i < n; ++i) {
           if (nums[i] <= nums[i - 1]) prefix[i] = prefix[i - 1] + 1;
           else prefix[i] = 1;
       }

       for (int i = n - 2; i >= 0; --i) {
           if (nums[i] <= nums[i + 1]) suffix[i] = suffix[i + 1] + 1;
           else suffix[i] = 1;
       }

       for (int i = k; i < n - k; ++i) {
           if (prefix[i - 1] >= k && suffix[i + 1] >= k) ans.add(i);
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.goodIndices(nums, k));
        }

        sc.close();
    }
}
