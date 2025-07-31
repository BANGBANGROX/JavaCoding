import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Solution {
    public int powerfulInteger(final int[][] intervals, final int k) {
        // code here
        final TreeMap<Integer, Integer> count = new TreeMap<>();
        int runningCount = 0;
        int answer = -1;

        for (final int[] interval : intervals) {
            count.put(interval[0], count.getOrDefault(interval[0], 0) + 1);
            count.put(interval[1] + 1, count.getOrDefault(interval[1] + 1, 0) - 1);
        }

        for (final Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() < 0) {
                if (runningCount >= k) {
                    answer = entry.getKey() - 1;
                }
                runningCount += entry.getValue();
            } else {
                runningCount += entry.getValue();
                if (runningCount >= k) {
                    answer = entry.getKey();
                }
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
           final int n = scanner.nextInt();
           final int[][] intervals = new int[n][2];
           for (int i = 0; i < n; ++i) {
               intervals[i][0] = scanner.nextInt();
               intervals[i][1] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().powerfulInteger(intervals, k));
       }
       
       scanner.close();
   }
}
