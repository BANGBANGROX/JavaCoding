import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Solution {
    private int n;
    private int[] nums;

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        this.n = n;
        this.nums = nums;
        final int[][] intervals = new int[n][2];
        final int q = queries.length;
        final boolean[] answer = new boolean[q];

        for (int i = 0; i < n; ++i) {
            int greaterIdx = getIndexGreaterOrEqual(nums[i] - maxDiff);
            int lesserIdx = getIndexLesserOrEqual(nums[i] + maxDiff);
            if (greaterIdx == -1) {
                greaterIdx = i;
            }
            if (lesserIdx == -1) {
                lesserIdx = i;
            }
            intervals[i][0] = greaterIdx;
            intervals[i][1] = lesserIdx;
        }

        final List<List<Integer>> mergedIntervals = mergeIntervals(intervals);
        final Map<Integer, Integer> nodeToConnectedComponentMap =
                buildNodeToConnectedComponentMap(mergedIntervals);

        for (int i = 0; i < q; ++i) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = Objects.equals(nodeToConnectedComponentMap.get(u), nodeToConnectedComponentMap.get(v));
        }

        return answer;
    }

    private int getIndexGreaterOrEqual(final int key) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            final int mid = (left + ((right - left) >> 1));
            if (nums[mid] >= key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private int getIndexLesserOrEqual(final int key) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            final int mid = (left + ((right - left) >> 1));
            if (nums[mid] <= key) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private List<List<Integer>> mergeIntervals(final int[][] intervals) {
        final List<List<Integer>> result = new ArrayList<>();
        int lastR = intervals[0][1];

        result.add(List.of(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < n; ++i) {
            final int left = intervals[i][0];
            final int right = intervals[i][1];
            if (left > lastR) {
                result.add(List.of(left, right));
                lastR = right;
            } else {
                final List<Integer> last = result.removeLast();
                result.add(List.of(Math.min(last.get(0), left), Math.max(last.get(1), right)));
                lastR = Math.max(last.get(1), right);
            }
        }

        return result;
    }

    private Map<Integer, Integer> buildNodeToConnectedComponentMap(List<List<Integer>> intervals) {
        final Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < intervals.size(); ++i) {
            int first = intervals.get(i).getFirst();
            int last = intervals.get(i).getLast();
            for (int x = first; x <= last; ++x) {
                result.put(x, i);
            }
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           final int maxDiff = scanner.nextInt();
           final int q = scanner.nextInt();
           final int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           final boolean[] answer = new Solution().pathExistenceQueries(n, nums, maxDiff, queries);
           for (final boolean x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
