import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Long> availableRooms = new PriorityQueue<>();
        PriorityQueue<ArrayList<Long>> busyRooms = new PriorityQueue<>(
                (a, b) -> (int) (!Objects.equals(a.get(0), b.get(0)) ?
                        a.get(0) - b.get(0) : a.get(1) - b.get(1))
        );
        int[] count = new int[n];

        Arrays.sort(meetings, Comparator.comparing(a -> a[0]));

        for (long i = 0; i < n; ++i) {
            availableRooms.add(i);
        }

        for (int[] m : meetings) {
            while (!busyRooms.isEmpty() && busyRooms.peek().get(0) <= m[0]) {
                availableRooms.add(busyRooms.poll().get(1));
            }
            long start;
            if (availableRooms.isEmpty()) {
                assert busyRooms.peek() != null;
                start = busyRooms.peek().get(0);
            }
            else {
                start = m[0];
            }
            long duration = m[1] - m[0];
            long room = (availableRooms.isEmpty() ? busyRooms.peek().get(1) :
                    availableRooms.peek());
            if (availableRooms.isEmpty()) busyRooms.poll();
            else availableRooms.poll();
            ++count[(int) room];
            busyRooms.add(new ArrayList<>(Arrays.asList(start + duration, room)));
        }

        int ans = 0;

        for (int i = 1; i < n; ++i) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; ++i) {
                meetings[i][0] = sc.nextInt();
                meetings[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.mostBooked(n, meetings));
        }

        sc.close();
    }
}
