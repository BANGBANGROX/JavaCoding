import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int maxEvents(int[][] events) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        final Map<Integer, List<Integer>> endDays = new HashMap<>();
        int maxEndTime = 0;
        int minStartTime = Integer.MAX_VALUE;
        int answer = 0;

        for (final int[] event : events) {
            endDays.computeIfAbsent(event[0], k -> new ArrayList<>()).add(event[1]);
            minStartTime = Math.min(minStartTime, event[0]);
            maxEndTime = Math.max(maxEndTime, event[1]);
        }

        for (int i = minStartTime; i <= maxEndTime; ++i) {
            if (endDays.containsKey(i)) {
                priorityQueue.addAll(endDays.get(i));
            }
            if (!priorityQueue.isEmpty()) {
                ++answer;
                priorityQueue.poll();
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek() == i) {
                priorityQueue.poll();
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
           final int[][] events = new int[n][2];
           for (int i = 0; i < n; ++i) {
               events[i][0] = scanner.nextInt();
               events[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().maxEvents(events));
       }
       
       scanner.close();
   }
}
