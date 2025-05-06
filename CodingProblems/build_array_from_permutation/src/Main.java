import java.util.Scanner;

class Solution {
    public int[] buildArray(final int[] nums) {
        final int n = nums.length;
        final int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            answer[i] = nums[nums[i]];
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           final int[] answer = new Solution().buildArray(nums);
           for (final int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
