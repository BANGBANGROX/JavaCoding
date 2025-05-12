//{ Driver Code Starts
// Initial Template for Java

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    private record Room(int roomIndex, int freeTime) {
    }

    public int mostBooked(final int n, final int[][] meetings) {
        // code here
        final PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        final PriorityQueue<Room> busyRooms = new PriorityQueue<>((a, b) -> a.freeTime != b.freeTime ?
                a.freeTime - b.freeTime : a.roomIndex - b.roomIndex);
        final int[] meetingCount = new int[n];

        for (int i = 0; i < n; ++i) {
            availableRooms.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (final int[] meeting : meetings) {
            final int startTime = meeting[0];
            final int endTime = meeting[1];
            while (!busyRooms.isEmpty() && busyRooms.peek().freeTime <= startTime) {
                availableRooms.offer(busyRooms.peek().roomIndex);
                busyRooms.poll();
            }
            if (!availableRooms.isEmpty()) {
                final int roomIndex = availableRooms.poll();
                ++meetingCount[roomIndex];
                busyRooms.offer(new Room(roomIndex, endTime));
            } else {
                final Room room = busyRooms.poll();
                assert room != null;
                final int meetingDuration = endTime - startTime;
                busyRooms.offer(new Room(room.roomIndex, room.freeTime + meetingDuration));
                ++meetingCount[room.roomIndex];
            }
        }

        int maxMeetingCount = meetingCount[0];
        int maxMeetingIndex = 0;

        for (int i = 1; i < n; ++i) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingIndex = i;
            }
        }

        return maxMeetingIndex;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends