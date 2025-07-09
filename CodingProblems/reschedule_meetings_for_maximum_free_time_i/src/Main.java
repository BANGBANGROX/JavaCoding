import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int maxFreeTime(final int eventTime, final int k, final int[] startTime, final int[] endTime) {
        final List<Integer> gaps = new ArrayList<>();
        int lastEnd = 0;
        final int n = startTime.length;
        int left = 0;
        int answer = 0;
        int runningGap = 0;

        for (int i = 0; i < n; ++i) {
            gaps.add(startTime[i] - lastEnd);
            lastEnd = endTime[i];
        }

        gaps.add(eventTime - lastEnd);

        for (int right = 0; right <= n; ++right) {
            if (right - left > k) {
                runningGap -= gaps.get(left);
                ++left;
            }
            runningGap += gaps.get(right);
            answer = Math.max(answer, runningGap);
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
           final int k = scanner.nextInt();
           final int n = scanner.nextInt();
           final int[] startTime = new int[n];
           for (int i = 0; i < n; ++i) {
               startTime[i] = scanner.nextInt();
           }
           final int[] endTime = new int[n];
           for (int i = 0; i < n; ++i) {
               endTime[i] = scanner.nextInt();
           }

           System.out.println(new Solution().maxFreeTime(eventTime, k, startTime, endTime));
       }
       
       scanner.close();
   }
}
