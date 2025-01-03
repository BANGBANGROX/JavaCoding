import java.util.Scanner;

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int answer = 0;
        long runningPrefixSum = 0;
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < n - 1; ++i) {
            runningPrefixSum += nums[i];
            if (runningPrefixSum >= totalSum - runningPrefixSum) {
                ++answer;
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

           System.out.println(new Solution().waysToSplitArray(nums));
       }
       
       scanner.close();
   }
}
