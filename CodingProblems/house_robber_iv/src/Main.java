import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] nums;
    private int k;

    private boolean check(int val) {
        int total = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (nums[i] <= val) {
                ++total;
                ++i;
            }
        }

        return total >= k;
    }

    public int minCapability(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
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
       }
       
       scanner.close();
   }
}
