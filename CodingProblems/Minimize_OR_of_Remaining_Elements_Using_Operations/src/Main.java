import java.util.Scanner;

class Solution {
    public int minOrAfterOperations(int[] nums, int k) {
         int answer = 0;
         int n = nums.length;
         final int ALL_BITS_SET = (1 << 30) - 1;

         for (int bit = 30; bit >= 0; --bit) {
             int zeroBitCount = 0;
             int currentAnd = ALL_BITS_SET;
             int target = answer | ((1 << bit) - 1);
             for (int num : nums) {
                 currentAnd &= num;
                 if ((currentAnd | target) == target) {
                     ++zeroBitCount;
                     currentAnd = ALL_BITS_SET;
                 }
             }
             if (n - zeroBitCount > k) {
                 answer |= (1 << bit);
             }
         }

         return answer;
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
            System.out.println(solution.minOrAfterOperations(nums, k));
        }

        sc.close();
    }
}
