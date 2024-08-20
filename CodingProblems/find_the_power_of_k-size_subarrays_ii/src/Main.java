import java.util.Scanner;

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] runningLength = new int[n];
        int[] answer = new int[n - k + 1];
        int right = k - 1;
        int itr = 0;

        runningLength[0] = 1;

        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                runningLength[i] = runningLength[i - 1] + 1;
            } else {
                runningLength[i] = 1;
            }
        }

        while (right < n) {
            if (runningLength[right] >= k) {
                answer[itr] = nums[right];
            } else {
                answer[itr] = -1;
            }
            ++right;
            ++itr;
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

           int[] answer = new Solution().resultsArray(nums, k);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
   }
}
