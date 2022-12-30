import java.util.*;

class Solution {
    private boolean[][] visited;
    private int[][] grid;
    private int m;
    private int n;
    private PriorityQueue<ArrayList<Integer>> pq;

    private int bfs(int key) {
        int result = 0;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        while (!pq.isEmpty()) {
            ArrayList<Integer> cell = pq.peek();
            int value = cell.get(0);
            if (value >= key) break;
            ++result;
            pq.poll();
            int x = cell.get(1);
            int y = cell.get(2);
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]) {
                    pq.add(new ArrayList<>(Arrays.asList(grid[newX][newY],newX,newY)));
                    visited[newX][newY] = true;
                }
            }
        }

        return result;
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int q = queries.length;
        m = grid.length;
        n = grid[0].length;
        int[] ans = new int[q];
        int[] prefix = new int[q];
        this.grid = grid;
        visited = new boolean[m][n];
        ArrayList<ArrayList<Integer>> indexedQueries = new ArrayList<>();
        pq = new PriorityQueue<>((a, b) -> !Objects.equals(a.get(0), b.get(0)) ?
                a.get(0) - b.get(0) : !Objects.equals(a.get(1), b.get(1))
                ? a.get(1) - b.get(1) : a.get(2) - b.get(2));

        for (int i = 0; i < q; ++i) {
            indexedQueries.add(new ArrayList<>(Arrays.asList(queries[i], i)));
        }

        indexedQueries.sort((a, b) ->
                !Objects.equals(a.get(0), b.get(0)) ? a.get(0) - b.get(0) :
                        a.get(1) - b.get(1));


        pq.add(new ArrayList<>(Arrays.asList(grid[0][0], 0, 0)));
        visited[0][0] = true;

        for (int i = 0; i < q; ++i) {
            ArrayList<Integer> query = indexedQueries.get(i);
            int key = query.get(0);
            int index = query.get(1);
            int result = bfs(key);
            if (i == 0) {
                prefix[i] = result;
            }
            else {
                prefix[i] = prefix[i - 1] + result;
            }
            ans[index] = prefix[i];
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int q = sc.nextInt();
            int[] queries = new int[q];
            for (int i = 0; i < q; ++i) {
                queries[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.maxPoints(grid, queries);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
