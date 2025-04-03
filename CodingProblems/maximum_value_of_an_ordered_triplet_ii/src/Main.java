import java.util.Scanner;

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] suffixMaximum = new int[n];
        int currentPrefixMax = nums[0];
        long answer = 0;

        suffixMaximum[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            suffixMaximum[i] = Math.max(suffixMaximum[i + 1], nums[i]);
        }

        for (int i = 1; i < n - 1; ++i) {
            if (currentPrefixMax > nums[i]) {
                answer = Math.max(answer, ((long) currentPrefixMax - nums[i]) * suffixMaximum[i + 1]);
            }
            currentPrefixMax = Math.max(currentPrefixMax, nums[i]);
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

           System.out.println(new Solution().maximumTripletValue(nums));
       }
       
       scanner.close();
   }
}
