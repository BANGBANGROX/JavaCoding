import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int findLHS(final int[] nums) {
        final Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (final int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            final int lesserCount = count.getOrDefault(num - 1, 0);
            final int greaterCount = count.getOrDefault(num + 1, 0);
            if (lesserCount > 0) {
                answer = Math.max(answer, lesserCount + count.get(num));
            }
            if (greaterCount > 0) {
                answer = Math.max(answer, greaterCount + count.get(num));
            }
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

           System.out.println(new Solution().findLHS(nums));
       }
       
       scanner.close();
   }
}
