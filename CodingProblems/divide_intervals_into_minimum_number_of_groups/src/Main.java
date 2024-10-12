import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];

        for (int i = 0; i < n; ++i) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int first = startTime[0];
        int last = endTime[n - 1];
        int startItr = 0;
        int endItr = 0;
        int current = 0;
        int answer = 0;

        for (int i = first; i <= last; ++i) {
            while (startItr < n && startTime[startItr] <= i) {
                ++current;
                ++startItr;
            }
            answer = Math.max(answer, current);
            while (endItr < n && endTime[endItr] <= i) {
                --current;
                ++endItr;
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
           int[][] intervals = new int[n][2];
           for (int i = 0; i < n; ++i) {
               intervals[i][0] = scanner.nextInt();
               intervals[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().minGroups(intervals));
       }
       
       scanner.close();
   }
}
