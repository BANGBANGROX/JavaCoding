import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private static final int MAX_VALUE = 10005;
    private static final int[] digitSum = new int[MAX_VALUE];

    public Solution() {
        if (digitSum[1] == 1) return;

        for (int i = 1; i < MAX_VALUE; ++i) {
            digitSum[i] = computeDigitSum(i);
        }
    }

    private int computeDigitSum(final int num) {
        int current = num;
        int result = 0;

        while (current > 0) {
            result += current % 10;
            current /= 10;
        }

        return result;
    }

    public int countLargestGroup(final int n) {
        int mostFrequentSum = 1;
        int answer = 0;
        final Map<Integer, Integer> count = new HashMap<>();

        count.put(1, 1);

        for (int i = 2; i <= n; ++i) {
            final int currentDigitSum = digitSum[i];
            count.put(currentDigitSum, count.getOrDefault(currentDigitSum, 0) + 1);
            if (count.get(currentDigitSum) > mostFrequentSum) {
                mostFrequentSum = count.get(currentDigitSum);
            }
        }

        for (final Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == mostFrequentSum) {
                ++answer;
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
           System.out.println(new Solution().countLargestGroup(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
