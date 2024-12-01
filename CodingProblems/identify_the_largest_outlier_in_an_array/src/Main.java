import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int getLargestOutlier(int[] nums) {
        int totalSum = 0;
        int answer = Integer.MIN_VALUE;
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            totalSum += num;
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int requiredSum = totalSum - num;
            if ((requiredSum & 1) > 0) {
                continue;
            }
            int requiredNum = requiredSum / 2;
            if (requiredNum == num) {
                if (count.get(requiredNum) > 1) {
                    answer = Math.max(answer, num);
                }
            } else if (count.getOrDefault(requiredNum, 0) > 0) {
                answer = Math.max(answer, num);
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

           System.out.println(new Solution().getLargestOutlier(nums));
       }
       
       scanner.close();
   }
}
