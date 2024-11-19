import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = k - 1;
        long currentSum = 0;
        long answer = 0;
        int distinctElements = 0;
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[maxElement + 1];

        for (int i = left; i <= right; ++i) {
            currentSum += nums[i];
            ++count[nums[i]];
            if (count[nums[i]] == 1) {
                ++distinctElements;
            }
        }

        while (right < n) {
            if (distinctElements == k) {
                answer = Math.max(answer, currentSum);
            }
            --count[nums[left]];
            currentSum -= nums[left];
            if (count[nums[left]] == 0) {
                --distinctElements;
            }
            ++left;
            ++right;
            if (right < n) {
                currentSum += nums[right];
                ++count[nums[right]];
                if (count[nums[right]] == 1) {
                    ++distinctElements;
                }
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

           System.out.println(new Solution().maximumSubarraySum(nums, k));
       }
       
       scanner.close();
   }
}
