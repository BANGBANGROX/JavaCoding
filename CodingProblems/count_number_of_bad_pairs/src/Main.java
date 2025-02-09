import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> pairsCount = new HashMap<>();
        int n = nums.length;
        long answer = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; ++i) {
            pairsCount.put(i - nums[i],
                    pairsCount.getOrDefault(i - nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : pairsCount.entrySet()) {
            answer -= (long) entry.getValue() * (entry.getValue() - 1) / 2;
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

           System.out.println(new Solution().countBadPairs(nums));
       }
       
       scanner.close();
   }
}
