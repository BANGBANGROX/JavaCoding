import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxDifference(final String s, final int k) {
        final int n = s.length();
        int answer = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int previousA = 0;
                int previousB = 0;
                int currentA = 0;
                int currentB = 0;
                int left = -1;
                final int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                for (int right = 0; right < n; ++right) {
                    currentA += (s.charAt(right) == a ? 1 : 0);
                    currentB += (s.charAt(right) == b ? 1 : 0);
                    while (right - left >= k && currentB - previousB >= 2) {
                        ++left;
                        final int leftStatus = getStatus(previousA, previousB);
                        best[leftStatus] = Math.min(best[leftStatus], previousA - previousB);
                        previousA += (s.charAt(left) == a ? 1 : 0);
                        previousB += (s.charAt(left) == b ? 1 : 0);
                    }
                    final int rightStatus = getStatus(currentA, currentB);
                    if (best[rightStatus ^ 2] != Integer.MAX_VALUE) {
                        answer = Math.max(answer, currentA - currentB - best[rightStatus ^ 2]);
                    }
                }
            }
        }

        return answer;
    }

    private int getStatus(int a, int b) {
        return ((a & 1) <<  1) | (b & 1);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().maxDifference(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
