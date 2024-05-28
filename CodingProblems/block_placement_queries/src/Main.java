import java.util.*;

class Solution {
    private static class FenwickTree {
        int[] bit;
        int size;

        FenwickTree(int size) {
            this.size = size;
            bit = new int[size + 1];
        }

        public void update(int idx, int val) {
            while (idx <= size) {
                bit[idx] = Math.max(bit[idx], val);
                idx += (idx & (-1 * idx));
            }
        }

        public int query(int idx) {
            int result = 0;

            while (idx > 0) {
                result = Math.max(result, bit[idx]);
                idx -= (idx & (-1 * idx));
            }

            return result;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> answer = new ArrayList<>();
        TreeSet<Integer> obstacles = new TreeSet<>();
        int q = queries.length;
        final int MAX_SIZE = Math.max(5 * (int) 1e4, 3 * queries.length);
        FenwickTree fenwickTree = new FenwickTree(MAX_SIZE);

        obstacles.add(0);
        obstacles.add(MAX_SIZE);

        for (int[] query : queries) {
            if (query[0] == 1) {
                obstacles.add(query[1]);
            }
        }

        int lastVal = -1;

        for (int val : obstacles) {
            if (lastVal != -1) {
                fenwickTree.update(val, val - lastVal);
            }
            lastVal = val;
        }

        for (int i = q - 1; i >= 0; --i) {
            int[] query = queries[i];
            int type = query[0];
            int x = query[1];
            int previous = obstacles.lower(x);
            int next = obstacles.higher(x);
            if (type == 1) {
                obstacles.remove(x);
                fenwickTree.update(next, next - previous);
            }
            else {
                int maxSize = Math.max(fenwickTree.query(previous), x - previous);
                answer.add(maxSize >= query[2]);
            }
        }

        Collections.reverse(answer);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int q = sc.nextInt();
            int[][] queries = new int[q][];
            for (int i = 0; i < q; ++i) {
                int type = sc.nextInt();
                if (type == 1) {
                    queries[i] = new int[2];
                    queries[i][0] = type;
                    queries[i][1] = sc.nextInt();
                }
                else {
                    queries[i] = new int[3];
                    queries[i][0] = type;
                    queries[i][1] = sc.nextInt();
                    queries[i][2] = sc.nextInt();
                }
            }

            System.out.println(new Solution().getResults(queries));
        }

        sc.close();
    }
}
