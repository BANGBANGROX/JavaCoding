import java.util.*;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> count = new HashMap<>();
        ArrayList<Integer> points = new ArrayList<>();
        long answer = 0;

        for (int i = 0; i < n; ++i) {
            points.add(i);
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            if (!count.containsKey(u)) {
                count.put(u, 0);
            }
            if (!count.containsKey(v)) {
                count.put(v, 0);
            }
            count.put(u, count.get(u) + 1);
            count.put(v, count.get(v) + 1);
        }

        points.sort(Comparator.comparingInt(a -> count.getOrDefault(a, 0)));

        for (int i = 0; i < points.size(); ++i) {
            answer += (i + 1L) * count.getOrDefault(points.get(i), 0);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] edges = new int[m][2];
            for (int i = 0; i < m; ++i) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }

            System.out.println(new Solution().maximumImportance(n, edges));
        }

        scanner.close();
    }
}
