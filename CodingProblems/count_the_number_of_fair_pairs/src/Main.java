import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] nums;

    private int greaterThanEqualToIndex(int value) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    private int lessThanEqualToIndex(int value) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] <= value) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        this.nums = nums;
        long answer = 0;

        Arrays.sort(this.nums);

        for (int num : nums) {
            int leftValue = lower - num;
            int rightValue = upper - num;
            int greaterThanIndex = greaterThanEqualToIndex(leftValue);
            int lessThanIndex = lessThanEqualToIndex(rightValue);
            if (lessThanIndex != -1 && greaterThanIndex != -1) {
                answer += (lessThanIndex - greaterThanIndex + 1);
                if (num >= leftValue && num <= rightValue) {
                    --answer;
                }
            }
        }

        return answer / 2;
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
           int lower = scanner.nextInt();
           int upper = scanner.nextInt();

           System.out.println(new Solution().countFairPairs(nums, lower, upper));
       }
       
       scanner.close();
   }
}
