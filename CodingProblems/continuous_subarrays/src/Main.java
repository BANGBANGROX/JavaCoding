import java.util.Scanner;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long answer = 1;
        int left = 0;
        int minValue = nums[0] - 2;
        int maxValue = nums[0] + 2;

        for (int right = 1; right < n; ++right) {
            if (nums[right] >= minValue && nums[right] <= maxValue) {
                minValue = Math.max(minValue, nums[right] - 2);
                maxValue = Math.min(maxValue, nums[right] + 2);
            } else {
                left = right - 1;
                minValue = nums[right] - 2;
                maxValue = nums[right] + 2;
                while (nums[left] >= minValue && nums[left] <= maxValue) {
                    minValue = Math.max(minValue, nums[left] - 2);
                    maxValue = Math.min(maxValue, nums[left] + 2);
                    --left;
                }
                ++left;
            }
            answer += (right - left + 1);
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

           System.out.println(new Solution().continuousSubarrays(nums));
       }
       
       scanner.close();
   }
}
