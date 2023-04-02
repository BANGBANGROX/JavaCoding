import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int ans = w;
        int idx = 0;
        int[][] investment = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a));

        for (int i = 0; i < n; ++i) {
            investment[i][0] = capital[i];
            investment[i][1] = profits[i];
        }

        Arrays.sort(investment, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        while (k > 0) {
            while (idx < n && investment[idx][0] <= ans) {
                pq.add(investment[idx][1]);
                ++idx;
            }
            if (pq.isEmpty()) break;
            ans += pq.poll();
            --k;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int k = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            int[] profits = new int[n];
            for (int i = 0; i < n; ++i) {
                profits[i] = sc.nextInt();
            }
            int[] capital = new int[n];
            for (int i = 0; i < n; ++i) {
                capital[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.findMaximizedCapital(k, w, profits, capital));
        }

        sc.close();
    }
}
