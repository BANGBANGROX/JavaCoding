import java.util.Scanner;

class Solution {
    private String s;
    private int n;

    public int cuts(final String s) {
        // code here
        this.s = s;
        n = s.length();
        int answer = cutsHandler(0, 0);

        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    private int cutsHandler(final int idx, final int currentSum) {
        if (idx >= n) {
            return isPowerOfFive(currentSum) ? 1 : Integer.MAX_VALUE;
        }

        final int nextSum = currentSum * 2 + (s.charAt(idx) - '0');

        if (nextSum == 0) {
            return Integer.MAX_VALUE;
        }

        int result = Integer.MAX_VALUE;

        if (isPowerOfFive(nextSum)) {
            final int next = cutsHandler(idx + 1, 0);

            if (next != Integer.MAX_VALUE) {
                result = Math.min(result, next + 1);
            }
        }

        final int next = cutsHandler(idx + 1, nextSum);

        if (next != Integer.MAX_VALUE) {
            result = Math.min(result, next);
        }

        return result;
    }

    private boolean isPowerOfFive(final int num) {
        if (num == 0) {
            return true;
        }

        int current = num;

        while (current % 5 == 0) {
            current /= 5;
        }

        return current == 1;
    }
}


public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().cuts(scanner.next()));
       }
       
       scanner.close();
   }
}
