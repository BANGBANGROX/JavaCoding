import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;

        for (int pile : piles) {
            pq.add(pile);
        }

        while (k > 0) {
            assert pq.peek() != null;
            int x = pq.poll();
            pq.add((x + 1) / 2);
            --k;
        }

        while (!pq.isEmpty()) {
            ans += pq.poll();
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
            int[] piles = new int[n];
            for (int i = 0; i < n; ++i) {
                piles[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minStoneSum(piles, k));
        }

        sc.close();
    }
}
