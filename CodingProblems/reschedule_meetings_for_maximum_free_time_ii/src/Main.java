import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxFreeTime(final int eventTime, final int[] startTime, final int[] endTime) {
        final int[][] top3Gaps = new int[3][2];
        final int n = startTime.length;
        int answer = 0;
        int lastEnd = 0;

        for (final int[] row : top3Gaps) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; ++i) {
            final int gap = (startTime[i] - lastEnd);
            if (gap > top3Gaps[2][0]) {
                top3Gaps[2][0] = gap;
                top3Gaps[2][1] = i;
                Arrays.sort(top3Gaps, (a, b) -> b[0] - a[0]);
            }
            lastEnd = endTime[i];
        }

        final int gap = (eventTime - lastEnd);

        if (gap > top3Gaps[2][0]) {
            top3Gaps[2][0] = gap;
            top3Gaps[2][1] = n;
            Arrays.sort(top3Gaps, (a, b) -> b[0] - a[0]);
        }

        for (int i = 0; i < n; ++i) {
            final int meetingDuration = endTime[i] - startTime[i];
            final int leftGap = (startTime[i] - (i == 0 ? 0 : endTime[i - 1]));
            final int rightGap = ((i == n - 1 ? eventTime : startTime[i + 1]) - endTime[i]);
            boolean found = false;
            for (final int[] topGap : top3Gaps) {
                if (topGap[0] >= meetingDuration && topGap[1] != i && topGap[1] != i + 1) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                answer = Math.max(answer, leftGap + rightGap);
            } else {
                answer = Math.max(answer, leftGap + rightGap + meetingDuration);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            final int eventTime = scanner.nextInt();
            final int n = scanner.nextInt();
            final int[] startTime = new int[n];
            for (int i = 0; i < n; ++i) {
                startTime[i] = scanner.nextInt();
            }
            final int[] endTime = new int[n];
            for (int i = 0; i < n; ++i) {
                endTime[i] = scanner.nextInt();
            }

            System.out.println(new Solution().maxFreeTime(eventTime, startTime, endTime));
        }

        scanner.close();
    }
}
