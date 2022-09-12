import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] players = new int[n][2];

        for (int i = 0; i < n; ++i) {
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }

        Arrays.sort(players, Comparator.comparingInt(a -> -1 * a[0]));

        long ans = 0;
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            if (pq.size() >= k) {
                total -= pq.remove();
            }
            pq.add(players[i][1]);
            total += players[i][1];
            ans = Math.max(ans, total * players[i][0]);
        }

        return (int) ans % 1000000007;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int i = 0; i < n; ++i) {
                speed[i] = sc.nextInt();
            }
            int[] efficiency = new int[n];
            for (int i = 0; i < n; ++i) {
                efficiency[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maxPerformance(n, speed, efficiency, k));
        }

        sc.close();
    }
}
