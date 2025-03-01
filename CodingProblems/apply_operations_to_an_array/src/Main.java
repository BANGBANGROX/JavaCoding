import java.util.Scanner;

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int itr = 0;

        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int num : nums) {
            if (num == 0) {
                answer[itr] = 0;
                ++itr;
            }
        }

        for (int num : nums) {
            if (num != 0) {
                answer[itr] = num;
                ++itr;
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

           int[] answer = new Solution().applyOperations(nums);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
