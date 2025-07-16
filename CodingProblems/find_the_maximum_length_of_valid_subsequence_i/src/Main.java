import java.util.Scanner;

class Solution {
    private int[] parityNums;

    public int maximumLength(final int[] nums) {
        final int n = nums.length;
        final int[][] options = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int answer = 0;
        parityNums = new int[n];

        for (int i = 0; i < n; ++i) {
            parityNums[i] = getParity(nums[i]);
        }

        for (final int[] option : options) {
            answer = Math.max(answer, maxLengthGivenStartingParityAndExpectedParity(option[0], option[1]));
        }

        return answer;
    }

    private int maxLengthGivenStartingParityAndExpectedParity(final int startingParity, final int expectedParity) {
        int result = 0;
        int lastParity = -1;

        for (final int parity : parityNums) {
            if (lastParity == -1) {
                if (parity == startingParity) {
                    lastParity = startingParity;
                    ++result;
                }
            } else if (getParity(lastParity + parity) == expectedParity) {
                ++result;
                lastParity = parity;
            }
        }

        return result;
    }

    private int getParity(final int num) {
        return (num & 1) > 0 ? 1 : 0;
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

           System.out.println(new Solution().maximumLength(nums));
       }
       
       scanner.close();
   }
}
