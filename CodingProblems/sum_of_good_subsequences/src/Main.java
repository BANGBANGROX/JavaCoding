import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        int n = nums.length;

        assert n > 0;

        final int MOD = (int) 1e9 + 7;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        long[] left = new long[n];
        long[] right = new long[n];
        long[] count = new long[maxValue + 1];
        long answer = 0;

        count[nums[0]] = 1;

        for (int i = 1; i < n; ++i) {
            count[nums[i]] += 1;
            if (nums[i] - 1 >= 0) {
                left[i] += count[nums[i] - 1];
                count[nums[i]] += count[nums[i] - 1];
            }
            if (nums[i] + 1 <= maxValue) {
                left[i] += count[nums[i] + 1];
                count[nums[i]] += count[nums[i] + 1];
            }
            left[i] %= MOD;
            count[nums[i]] %= MOD;
        }

        count = new long[maxValue + 1];
        count[nums[n - 1]] = 1;

        for (int i = n - 2; i >= 0; --i) {
            count[nums[i]] += 1;
            if (nums[i] - 1 >= 0) {
                right[i] += count[nums[i] - 1];
                count[nums[i]] += count[nums[i] - 1];
            }
            if (nums[i] + 1 <= maxValue) {
                right[i] += count[nums[i] + 1];
                count[nums[i]] += count[nums[i] + 1];
            }
            right[i] %= MOD;
            count[nums[i]] %= MOD;
        }

        for (int i = 0; i < n; ++i) {
            long mul = ((left[i] * right[i]) % MOD +
                    left[i] + right[i] + 1) % MOD;
            answer = (answer + (mul * nums[i]) % MOD) % MOD;
        }

        return (int) answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().sumOfGoodSubsequences(nums));
       }
       
       scanner.close();
   }
}
