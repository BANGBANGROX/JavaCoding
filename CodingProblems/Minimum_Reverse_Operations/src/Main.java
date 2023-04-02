import java.util.*;

class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] skip = new boolean[n];
        int[] result = new int[n];
        int moves = 0;

        for (int ban : banned) {
            skip[ban] = true;
        }

        for (int i = 0; i < n; ++i) {
            if (i == p || skip[i]) continue;
            if ((i & 1) == 0) {
                even.add(i);
            }
            else {
                odd.add(i);
            }
        }

        q.add(p);
        Arrays.fill(result, -1);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                int current = q.poll();
                result[current] = moves;
                int minIndex = k - current - 1;
                int currentMaxIndex = n - current - 1;
                int maxIndex = k - currentMaxIndex - 1;
                if (minIndex < 0) {
                    minIndex = current - k + 1;
                }
                if (maxIndex < 0) {
                    maxIndex = currentMaxIndex - k + 1;
                }
                maxIndex = n - maxIndex - 1;
                TreeSet<Integer> currentSet = (minIndex & 1) == 0 ? even : odd;
                Integer key = currentSet.ceiling(minIndex);
                while (key != null && key <= maxIndex) {
                    q.add(key);
                    currentSet.remove(key);
                    key = currentSet.ceiling(minIndex);
                }
            }
            ++moves;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int m = sc.nextInt();
            int[] banned = new int[m];
            for (int i = 0; i < m; ++i) {
                banned[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            int[] ans = solution.minReverseOperations(n, p, banned, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
