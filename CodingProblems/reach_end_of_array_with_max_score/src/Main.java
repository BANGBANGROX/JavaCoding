import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long answer = 0;
        int runningMax = 0;

        for (int num : nums) {
            answer += runningMax;
            runningMax = Math.max(runningMax, num);
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

           System.out.println(new Solution().findMaximumScore(nums));
       }
       
       scanner.close();
   }
}
