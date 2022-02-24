import java.util.Scanner;

class Solution {
    public int singleNumber(int[] nums) {
         int ans = 0;

         for (int num : nums) {
             ans ^= num;
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
            System.out.println(solution.singleNumber(nums));
        }

        sc.close();
    }
}
