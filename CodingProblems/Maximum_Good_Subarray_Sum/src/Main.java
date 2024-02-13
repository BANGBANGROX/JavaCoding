import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long answer = Long.MIN_VALUE;
        long prefixSum = 0;
        HashMap<Integer, Long> numToMinPrefixSum = new HashMap<>();

        for (int num : nums) {
            if (numToMinPrefixSum.containsKey(num)) {
                numToMinPrefixSum.put(num, Math.min(numToMinPrefixSum.get(num), prefixSum));
            }
            else {
                numToMinPrefixSum.put(num, prefixSum);
            }
            prefixSum += num;
            if (numToMinPrefixSum.containsKey(num - k)) {
                answer = Math.max(answer, prefixSum - numToMinPrefixSum.get(num - k));
            }
            if (numToMinPrefixSum.containsKey(num + k)) {
                answer = Math.max(answer, prefixSum - numToMinPrefixSum.get(num + k));
            }
        }

        return answer == Long.MIN_VALUE ? 0 : answer;
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
            System.out.println(solution.maximumSubarraySum(nums, k));
        }

        sc.close();
    }
}
