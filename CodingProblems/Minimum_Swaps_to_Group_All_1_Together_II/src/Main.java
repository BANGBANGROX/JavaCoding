import java.util.Scanner;

class Solution {
    public int minSwaps(int[] nums) {
          int n = nums.length;
          int[] newNums = new int[2 * n];
          int[] prefix = new int[2 * n];
          int countOfOnes = 0;
          int maxOnes = 0;

          for (int num : nums) {
              if (num == 1) ++countOfOnes;
          }

          for (int i = 0; i < 2 * n; ++i) newNums[i] = nums[i % n];

          if (newNums[0] == 1) prefix[0] = 1;

          for (int i = 1; i < 2 * n; ++i) {
              prefix[i] = prefix[i - 1];
              if (newNums[i] == 1) prefix[i] += 1;
          }

          for (int i = countOfOnes - 1; i < 2 * n; ++i) {
              int currentOnes = prefix[i];
              if (i >= countOfOnes) currentOnes -= prefix[i - countOfOnes];
              maxOnes = Math.max(maxOnes, currentOnes);
          }

          return countOfOnes - maxOnes;
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
            System.out.println(solution.minSwaps(nums));
        }

        sc.close();
    }
}
