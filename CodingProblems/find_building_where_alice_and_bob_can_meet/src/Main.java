import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int q = queries.length;
        int n = heights.length;
        int[] answer = new int[q];
        List<List<List<Integer>>> remainingQueriesList = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(List::getFirst));

        Arrays.fill(answer, -1);

        for (int i = 0; i < n; ++i) {
            remainingQueriesList.add(new ArrayList<>());
        }

        for (int i = 0; i < q; ++i) {
            int aliceIdx = queries[i][0];
            int bobIdx = queries[i][1];
            if (aliceIdx < bobIdx && heights[aliceIdx] < heights[bobIdx]) {
                answer[i] = bobIdx;
            } else if (aliceIdx > bobIdx && heights[aliceIdx] > heights[bobIdx]) {
                answer[i] = aliceIdx;
            } else if (aliceIdx == bobIdx) {
                answer[i] = aliceIdx;
            } else {
                remainingQueriesList.get(Math.max(aliceIdx, bobIdx)).add(List.of(Math.max
                        (heights[aliceIdx], heights[bobIdx]), i));
            }
        }

        for (int i = 0; i < n; ++i) {
            while (!pq.isEmpty() && pq.peek().getFirst() < heights[i]) {
                answer[Objects.requireNonNull(pq.poll()).get(1)] = i;
            }
            for (List<Integer> query : remainingQueriesList.get(i)) {
                pq.offer(query);
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
           int[] heights = new int[n];
           for (int i = 0; i < n; ++i) {
               heights[i] = scanner.nextInt();
           }
           int q = scanner.nextInt();
           int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           int[] answer = new Solution().leftmostBuildingQueries(heights, queries);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
