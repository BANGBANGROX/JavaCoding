import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] prefixSum = new long[n];
        long[] maxPrefixSumForMod = new long[k];
        long answer = Long.MIN_VALUE;

        Arrays.fill(maxPrefixSumForMod, Long.MIN_VALUE);

        for (int i = 0; i < n; ++i) {
            prefixSum[i] = (nums[i] + (i > 0 ? prefixSum[i - 1] : 0));
            if (i > n - k) {
                maxPrefixSumForMod[i % k] = Math.max(maxPrefixSumForMod[i % k], prefixSum[i]);
            }
        }

        for (int start = n - k; start >= 0; --start) {
            int modValue = (start - 1 + k) % k;
            maxPrefixSumForMod[start % k] = Math.max(maxPrefixSumForMod[start % k],
                    prefixSum[start]);
            if (maxPrefixSumForMod[modValue] != Long.MIN_VALUE) {
                long currentSum = maxPrefixSumForMod[modValue] - (start > 0 ?
                        prefixSum[start - 1] : 0);
                answer = Math.max(answer, currentSum);
            }
        }

        return answer;
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
           int k = scanner.nextInt();

           System.out.println(new Solution().maxSubarraySum(nums, k));
       }
       
       scanner.close();
   }
}
