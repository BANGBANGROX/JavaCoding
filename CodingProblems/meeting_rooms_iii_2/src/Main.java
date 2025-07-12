import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int mostBooked(final int n, final int[][] meetings) {
        final int[] roomBookingsCount = new int[n];
        final PriorityQueue<List<Integer>> currentRoomStatusQueue = new PriorityQueue<>(
                (a, b) -> !Objects.equals(a.get(1), b.get(1)) ? a.get(1) - b.get(1) :
                        a.getFirst() - b.getFirst()
        );
        final PriorityQueue<Integer> availableRoomsQueue = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            availableRoomsQueue.offer(i);
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (final int[] meeting : meetings) {
            final int roomAssigned;
            final int meetingEndTime;

            while (!currentRoomStatusQueue.isEmpty() && currentRoomStatusQueue.peek().get(1) <= meeting[0]) {
                availableRoomsQueue.offer(currentRoomStatusQueue.poll().getFirst());
            }

            if (!availableRoomsQueue.isEmpty()) {
                roomAssigned = availableRoomsQueue.poll();
                meetingEndTime = meeting[1];
            } else {
                final List<Integer> firstRoomAvailableDetails = currentRoomStatusQueue.poll();
                roomAssigned = firstRoomAvailableDetails.getFirst();
                meetingEndTime = meeting[1] - meeting[0] + firstRoomAvailableDetails.get(1);
            }

            ++roomBookingsCount[roomAssigned];
            currentRoomStatusQueue.offer(List.of(roomAssigned, meetingEndTime));
        }

        for (int i = 1; i < n; ++i) {
            if (roomBookingsCount[i] > roomBookingsCount[answer]) {
                answer = i;
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
           final int m = scanner.nextInt();
           final int[][] meetings = new int[m][2];
           for (int i = 0; i < m; ++i) {
               meetings[i][0] = scanner.nextInt();
               meetings[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().mostBooked(n, meetings));
       }
       
       scanner.close();
   }
}
