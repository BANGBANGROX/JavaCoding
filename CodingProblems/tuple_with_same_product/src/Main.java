import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                count.put(nums[i] * nums[j],
                        count.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            answer += 4 * entry.getValue() * (entry.getValue() - 1);
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

           System.out.println(new Solution().tupleSameProduct(nums));
       }
       
       scanner.close();
   }
}
