import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private int computeDigitsSum(int num) {
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num /= 10;
        }

        return result;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> firstMax = new HashMap<>();
        Map<Integer, Integer> secondMax = new HashMap<>();
        int answer = -1;

        for (int num : nums) {
            int digitsSum = computeDigitsSum(num);
            if (!firstMax.containsKey(digitsSum)) {
                firstMax.put(digitsSum, num);
            } else if (firstMax.get(digitsSum) <= num) {
                secondMax.put(digitsSum, firstMax.get(digitsSum));
                firstMax.put(digitsSum, num);
            } else if (!secondMax.containsKey(digitsSum) || secondMax.get(digitsSum) <= num) {
                secondMax.put(digitsSum, num);
            }
        }

        for (int digitsSum : firstMax.keySet()) {
            if (secondMax.containsKey(digitsSum)) {
                answer = Math.max(answer, firstMax.get(digitsSum) + secondMax.get(digitsSum));
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

           System.out.println(new Solution().maximumSum(nums));
       }
       
       scanner.close();
   }
}
