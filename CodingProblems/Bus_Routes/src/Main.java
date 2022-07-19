import java.awt.*;
import java.util.*;

class Solution {
    private boolean intersect(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int m = a.length;
        int n = b.length;

        while (i < m && j < n) {
            if (a[i] == b[j]) return true;
            if (a[i] < b[j]) ++i;
            else ++j;
        }

        return false;
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> targets = new HashSet<>();
        Queue<Point> q = new LinkedList<>();
        int n = routes.length;

        for (int[] route : routes) {
            Arrays.sort(route);
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            if (Arrays.binarySearch(routes[i], source) >= 0) {
                visited.add(i);
                q.add(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], target) >= 0) {
                targets.add(i);
            }
            for (int j = i + 1; j < n; ++j) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        while (!q.isEmpty()) {
            Point current = q.poll();
            int node = current.x;
            int depth = current.y;
            if (targets.contains(node)) return depth + 1;
            for (int child : graph.get(node)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    q.add(new Point(child, depth + 1));
                }
            }
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
            int[][] routes = new int[n][];
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                routes[i] = new int[m];
                for (int j = 0; j < m; ++j) {
                    routes[i][j] = sc.nextInt();
                }
            }
            int source = sc.nextInt();
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.numBusesToDestination(routes, source, target));
        }

        sc.close();
    }
}
