import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public ArrayList<int[]> insertInterval(final int[][] intervals, final int[] newInterval) {
        // code here
        final List<int[]> newIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            newIntervals.add(new int[]{interval[0], interval[1]});
        }

        newIntervals.add(new int[]{newInterval[0], newInterval[1]});
        newIntervals.sort(Comparator.comparingInt(a -> a[0]));

        return mergeIntervals(newIntervals);
    }

    private ArrayList<int[]> mergeIntervals(final List<int[]> intervals) {
        final List<int[]> mergedIntervals = new LinkedList<>();
        int lastEnd = intervals.getFirst()[1];

        mergedIntervals.add(new int[]{intervals.getFirst()[0], intervals.getFirst()[1]});

        for (int i = 1; i < intervals.size(); ++i) {
            final int start = intervals.get(i)[0];
            final int end = intervals.get(i)[1];

            if (start > lastEnd) {
                mergedIntervals.add(new int[]{start, end});
                lastEnd = end;
            } else {
                final int[] last = mergedIntervals.removeLast();
                mergedIntervals.add(new int[]{last[0], Math.max(lastEnd, end)});
                lastEnd = Math.max(lastEnd, end);
            }
        }

        return new ArrayList<>(mergedIntervals);
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
           final int[] newInterval = new int[]{scanner.nextInt(), scanner.nextInt()};

           for (final int[] interval : new Solution().insertInterval(intervals, newInterval)) {
               System.out.println(interval[0] + " " + interval[1]);
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
