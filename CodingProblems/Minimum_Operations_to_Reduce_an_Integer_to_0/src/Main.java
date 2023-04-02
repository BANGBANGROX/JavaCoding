import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int minOperations(int n) {
        final int MAX_N = 1_000_000;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX_N];

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                int num = q.poll();
                for (int val = 0; num + (1 << val) < MAX_N; ++val) {
                    int next = num + (1 << val);
                    if (next == n) return ans + 1;
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
                for (int val = 0; num - (1 << val) >= 0; ++val) {
                    int next = num - (1 << val);
                    if (next == n) return ans + 1;
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            ++ans;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minOperations(n));
        }

        sc.close();
    }
}
