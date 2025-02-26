import java.util.Scanner;

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int answer = 0;
        int runningSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            runningSum += num;
            answer = Math.max(answer, Math.abs(runningSum));
            if (maxSum != Integer.MIN_VALUE && minSum != Integer.MAX_VALUE) {
                answer = Math.max(answer, Math.max(Math.abs(runningSum - maxSum),
                        Math.abs(runningSum - minSum)));
            }
            maxSum = Math.max(maxSum, runningSum);
            minSum = Math.min(minSum, runningSum);
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

           System.out.println(new Solution().maxAbsoluteSum(nums));
       }
       
       scanner.close();
   }
}
