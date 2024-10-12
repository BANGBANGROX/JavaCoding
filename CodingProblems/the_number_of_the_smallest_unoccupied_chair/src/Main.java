import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<List<Integer>> events = new ArrayList<>();
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        PriorityQueue<List<Integer>> occupiedChairs = new PriorityQueue<>(Comparator
                .comparingInt(List::getFirst));
        int n = times.length;

        for (int i = 0; i < n; ++i) {
            events.add(List.of(times[i][0], i));
            events.add(List.of(times[i][1], ~i));
            availableChairs.add(i);
        }

        events.sort(Comparator.comparingInt(List::getFirst));

        for (List<Integer> event : events) {
            int time = event.getFirst();
            int friendIndex = event.get(1);
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek().getFirst() <= time) {
                availableChairs.add(Objects.requireNonNull(occupiedChairs.poll()).get(1));
            }
            if (friendIndex >= 0) {
                assert !availableChairs.isEmpty();
                int chair = availableChairs.poll();
                if (friendIndex == targetFriend) return chair;
                occupiedChairs.add(List.of(times[friendIndex][1], chair));
            }
        }

        return -1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[][] times = new int[n][2];
           for (int i = 0; i < n; ++i) {
               times[i][0] = scanner.nextInt();
               times[i][1] = scanner.nextInt();
           }
           int targetFriend = scanner.nextInt();

           System.out.println(new Solution().smallestChair(times, targetFriend));
       }
       
       scanner.close();
   }
}
