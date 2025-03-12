import java.util.Scanner;

class Solution {
    private int[] nums;
    private int n;

    private int getLastIndexLesserThanZero() {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] < 0) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private int getFirstIndexGreaterThanZero() {
        int left = 0;
        int right = n - 1;
        int result = n;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] > 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int maximumCount(int[] nums) {
        n = nums.length;
        this.nums = nums;

        if (nums[0] > 0) return nums.length;

        if (nums[n - 1] < 0) return n;

        int lastNegIndex = getLastIndexLesserThanZero();
        int firstPosIndex = getFirstIndexGreaterThanZero();

        return Math.max(lastNegIndex + 1, n - firstPosIndex);
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

           System.out.println(new Solution().maximumCount(nums));
       }
       
       scanner.close();
   }
}
