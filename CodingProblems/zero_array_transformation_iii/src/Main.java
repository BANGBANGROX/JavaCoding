import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int maxRemoval(final int[] nums, final int[][] queries) {
        final int n = nums.length;
        final int q = queries.length;
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> -1 * a));
        int activeQueries = 0;
        final int[] deltaArray = new int[n + 1];

        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        for (int i = 0, j = 0; i < n; ++i) {
            activeQueries += deltaArray[i];
            while (j < q && queries[j][0] == i) {
                maxHeap.offer(queries[j][1]);
                ++j;
            }
            while (nums[i] > activeQueries && !maxHeap.isEmpty() && maxHeap.peek() >= i) {
                ++activeQueries;
                --deltaArray[maxHeap.poll() + 1];
            }
            if (nums[i] > activeQueries) {
                return -1;
            }
        }

        return maxHeap.size();
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
           final int q = scanner.nextInt();
           final int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().maxRemoval(nums, queries));
       }
       
       scanner.close();
   }
}
