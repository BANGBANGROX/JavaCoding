import java.util.Scanner;

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int answer = 0;
        int left = 0;
        int right = 0;
        int[] rightMax = new int[n];

        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        while (right < n) {
            while (left < right && nums[left] > rightMax[right]) {
                ++left;
            }
            answer = Math.max(answer, right - left);
            ++right;
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

           System.out.println(new Solution().maxWidthRamp(nums));
       }
       
       scanner.close();
   }
}
