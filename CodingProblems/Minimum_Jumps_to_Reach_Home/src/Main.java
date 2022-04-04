import java.util.*;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int outerLimit = 40000;
        int ans = 0;
        HashSet<Integer> forbiddenPoints = new HashSet<>();
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        for (int point : forbidden) {
            forbiddenPoints.add(point);
        }

        q.add(new ArrayList<>(Arrays.asList(0, 1)));
        visited.add(new ArrayList<>(Arrays.asList(0, 1)));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                int node = q.peek().get(0);
                int lastMove = q.peek().get(1);
                q.poll();
                int forwardMove = node + a;
                int backwardMove = node - b;
                if (forwardMove <= outerLimit &&
                        !visited.contains(new ArrayList<>(Arrays.asList(forwardMove, 1))) && !forbiddenPoints.contains(forwardMove)) {
                    if (forwardMove == x) return ans + 1;
                    q.add(new ArrayList<>(Arrays.asList(forwardMove, 1)));
                    visited.add(new ArrayList<>(Arrays.asList(forwardMove, 1)));
                }
                if (backwardMove >= 0 && lastMove != 0 && !forbiddenPoints.contains(backwardMove) &&
                        !visited.contains(new ArrayList<>(Arrays.asList(backwardMove, 0)))) {
                    if (backwardMove == x) return ans + 1;
                    q.add(new ArrayList<>(Arrays.asList(backwardMove, 0)));
                    visited.add(new ArrayList<>(Arrays.asList(backwardMove, 0)));
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
            int[] forbidden = new int[n];
            for (int i = 0; i < n; ++i) {
                forbidden[i] = sc.nextInt();
            }
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumJumps(forbidden, a, b, x));
        }

        sc.close();
    }
}
