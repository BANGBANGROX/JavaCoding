import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

class Solution {
    public long countInterestingSubarrays(final List<Integer> nums,
                                          final int modulo, final int k) {
        final int n = nums.size();
        final Map<Integer, Integer> count = new HashMap<>();
        int runningCnt = 0;
        long answer = 0;

        count.put(0, 1);

        for (int i = 0; i < n; ++i) {
            runningCnt = (runningCnt + ((nums.get(i) % modulo) == k ? 1 : 0)) % modulo;
            final int firstRequiredCnt = runningCnt - k;
            final int secondRequiredCnt = runningCnt - k + modulo;
            answer += (count.getOrDefault(firstRequiredCnt, 0) + count.getOrDefault
                    (secondRequiredCnt, 0));
            count.put(runningCnt, count.getOrDefault(runningCnt, 0) + 1);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final List<Integer> nums = new ArrayList<>();
           for (int i = 0; i < n; ++i) {
               nums.add(scanner.nextInt());
           }
           final int modulo = scanner.nextInt();
           final int k = scanner.nextInt();

           System.out.println(new Solution().countInterestingSubarrays(nums, modulo, k));
       }
       
       scanner.close();
   }
}
