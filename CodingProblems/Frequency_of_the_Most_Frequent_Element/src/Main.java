import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxFrequency(int[] nums, int k) {
       Arrays.sort(nums);

       int ans = 0;
       int j = 0;
       long cnt = 0;
       int n = nums.length;

       for (int i = 1; i < n; ++i) {
           cnt += (long)(nums[i] - nums[i - 1]) * (i - j);
           while (cnt > k) {
               cnt -= (nums[i] - nums[j]);
               ++j;
           }
           ans = Math.max(ans, i - j + 1);
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
            System.out.println(solution.maxFrequency(nums, k));
        }

        sc.close();
    }
}
