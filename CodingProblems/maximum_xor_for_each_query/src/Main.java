import java.util.Scanner;

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int totalXor = 0;
        int n = nums.length;
        int[] answer = new int[n];
        int maxXor = (1 << maximumBit) - 1;

        for (int num : nums) {
            totalXor ^= num;
        }

        for (int i = 0; i < n; ++i) {
            answer[i] = totalXor ^ maxXor;
            totalXor ^= nums[n - i - 1];
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
           int maximumBit = scanner.nextInt();

           int[] answer = new Solution().getMaximumXor(nums, maximumBit);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
