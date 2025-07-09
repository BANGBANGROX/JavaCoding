import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][] events;
    private int[][] dp;
    private int n;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ?
                a[1] - b[1] : b[2] - a[2]);

        this.events = events;
        n = events.length;
        dp = new int[n][k + 1];

        for (final int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxValueHandle(0, k);
    }

    private int maxValueHandle(final int idx, int k) {
        if (idx >= n || k == 0) {
            return 0;
        }

        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }

        int result = maxValueHandle(idx + 1, k);
        final int nextIdx = getNextIdx(events[idx][1]);

        result = Math.max(result, events[idx][2] + maxValueHandle(nextIdx, k - 1));

        return dp[idx][k] = result;
    }

    private int getNextIdx(final int key) {
        int left = 0;
        int right = n - 1;
        int result = n;

        while (left <= right) {
            final int mid = (left + ((right - left) >> 1));

            if (events[mid][0] > key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[][] events = new int[n][3];
           for (int i = 0; i < n; ++i) {
               events[i][0] = scanner.nextInt();
               events[i][1] = scanner.nextInt();
               events[i][2] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().maxValue(events, k));
       }
       
       scanner.close();
   }
}
