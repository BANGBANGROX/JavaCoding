import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int answer = 0;

        Arrays.sort(nums);

        for (int right = 0; right < n; ++right) {
            while (nums[right] - nums[left] > 2 * k) {
                ++left;
            }
            answer = Math.max(answer, right - left + 1);
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

           System.out.println(new Solution().maximumBeauty(nums, k));
       }
       
       scanner.close();
   }
}
