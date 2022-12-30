import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ?
                a[1] - b[1] : a[2] - b[2]);
        int[][] sortedTasks = new int[n][];

        for (int i = 0; i < n; ++i) {
            sortedTasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));

        int ansIndex = 0;
        int taskIndex = 0;
        long currentTime = 0;

        while (taskIndex < n || !pq.isEmpty()) {
            if (pq.isEmpty() && currentTime < sortedTasks[taskIndex][0]) {
                currentTime = sortedTasks[taskIndex][0];
            }
            while (taskIndex < n && currentTime >= sortedTasks[taskIndex][0]) {
                pq.add(sortedTasks[taskIndex]);
                ++taskIndex;
            }
            assert pq.peek() != null;
            currentTime += pq.peek()[1];
            int index = pq.peek()[2];
            pq.poll();
            ans[ansIndex] = index;
            ++ansIndex;
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
            int[][] tasks = new int[n][2];
            for (int i = 0; i < n; ++i) {
                tasks[i][0] = sc.nextInt();
                tasks[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.getOrder(tasks);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
