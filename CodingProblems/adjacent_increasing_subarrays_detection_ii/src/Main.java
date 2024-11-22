import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int[] increasingLength;
    private int n;

    private boolean check(int length) {
        int end1 = length - 1;
        int end2 = 2 * length - 1;

        while (end2 < n) {
            if (increasingLength[end1] >= length && increasingLength[end2] >= length)
                return true;
            ++end1;
            ++end2;
        }

        return false;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        n = nums.size();
        increasingLength = new int[n];

        increasingLength[0] = 1;

        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                increasingLength[i] = increasingLength[i - 1] + 1;
            } else {
                increasingLength[i] = 1;
            }
        }

        int left = 0;
        int right = n / 2;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
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
           List<Integer> nums = new ArrayList<>();
           for (int i = 0; i < n; ++i) {
               nums.add(scanner.nextInt());
           }

           System.out.println(new Solution().maxIncreasingSubarrays(nums));
       }
       
       scanner.close();
   }
}
