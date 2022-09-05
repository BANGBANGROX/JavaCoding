import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> dq = new LinkedList<>();
        int l = 0;
        int n = runningCosts.length;
        long sum = 0;

        for (int r = 0; r < n; ++r) {
            sum += runningCosts[r];
            while (!dq.isEmpty() && chargeTimes[dq.getLast()] <= chargeTimes[r]) {
                dq.pollLast();
            }
            dq.add(r);
            if (chargeTimes[dq.peekFirst()] + (r - l + 1) * sum > budget) {
                if (dq.peekFirst() == l) dq.pollFirst();
                sum -= runningCosts[l];
                ++l;
            }
        }

        return n - l;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] chargeTimes = new int[n];
            for (int i = 0; i < n; ++i) {
                chargeTimes[i] = sc.nextInt();
            }
            int[] runningCosts = new int[n];
            for (int i = 0; i < n; ++i) {
                runningCosts[i] = sc.nextInt();
            }
            long budget = sc.nextLong();

            Solution solution = new Solution();
            System.out.println(solution.maximumRobots(chargeTimes, runningCosts, budget));
        }

        sc.close();
    }
}
