import java.util.Scanner;

class Solution {
    private int[] nums;
    private int maxOr;
    private int answer;

    private void findSubsets(int idx, int currentOr) {
        if (idx >= nums.length) {
            if (currentOr == maxOr) {
                ++answer;
            }
            return;
        }

        findSubsets(idx + 1, currentOr);
        findSubsets(idx + 1, currentOr | nums[idx]);
    }

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        answer = 0;
        maxOr = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        findSubsets(0, 0);

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

           System.out.println(new Solution().countMaxOrSubsets(nums));
       }
       
       scanner.close();
   }
}
