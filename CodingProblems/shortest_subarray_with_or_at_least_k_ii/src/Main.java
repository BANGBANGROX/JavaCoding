import java.util.Scanner;

class Solution {
    private int k;
    private final int TOTAL_BITS = 32;
    private int[] setBitsCount;

    private boolean compare() {
        for (int i = TOTAL_BITS - 1; i >= 0; --i) {
            if ((k & (1 << i)) > 0) {
                if (setBitsCount[i] == 0) return false;
            } else {
                if (setBitsCount[i] > 0) return true;
            }
        }

        return true;
    }

    private void updateSetBitsCount(int num, int delta) {
        for (int i = 0; i < TOTAL_BITS; ++i) {
            if ((num & (1 << i)) > 0) {
                setBitsCount[i] += delta;
            }
        }
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        setBitsCount = new int[TOTAL_BITS];
        this.k = k;
        int n = nums.length;
        int left = 0;
        int answer = n;
        int totalOr = 0;

        for (int right = 0; right < n; ++right) {
            updateSetBitsCount(nums[right], 1);
            totalOr |= nums[right];
            if (compare()) {
                while (left <= right && compare()) {
                    updateSetBitsCount(nums[left], -1);
                    ++left;
                }
                answer = Math.min(answer, right - left + 2);
            }
        }

        return totalOr < k ? -1 : answer;
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

           System.out.println(new Solution().minimumSubarrayLength(nums, k));
       }
       
       scanner.close();
   }
}
