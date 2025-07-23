import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int maximumUniqueSubarray(final int[] nums) {
        final int n = nums.length;
        int answer = 0;
        int currentSum = 0;
        final Map<Integer, Integer> lastIndex = new HashMap<>();
        final int[] prefixSum = new int[n];
        int left = 0;

        prefixSum[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int right = 0; right < n; ++right) {
            if (lastIndex.containsKey(nums[right])) {
                final int idx = lastIndex.get(nums[right]);
                if (idx >= left) {
                    currentSum -= (prefixSum[idx] - (left > 0 ? prefixSum[left - 1] : 0));
                    left = idx + 1;
                }
            }
            lastIndex.put(nums[right], right);
            currentSum += nums[right];
            answer = Math.max(answer, currentSum);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().maximumUniqueSubarray(nums));
       }
       
       scanner.close();
   }
}
