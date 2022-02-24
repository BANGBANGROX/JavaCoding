// { Driver Code Starts
import java.util.*;

class Gfg
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char[][] mat = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            Solution T = new Solution();
            int[][] ans = T.findDistance(mat, m, n);

            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int[][] findDistance(char[][] mat, int m, int n) {
        // Your code goes here
        int[][] distance = new int[m][n];
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 'B') {
                    distance[i][j] = 0;
                    q.add(new ArrayList<>(Arrays.asList(i, j)));
                }
                else {
                    distance[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            ArrayList<Integer> currentCell = q.poll();
            int x = currentCell.get(0);
            int y = currentCell.get(1);
            for (int i = 0; i < 4; ++i) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && mat[newX][newY] == 'O'
                && (distance[newX][newY] == -1 || distance[newX][newY] > 1 + distance[x][y])) {
                    distance[newX][newY] = 1 + distance[x][y];
                    q.add(new ArrayList<>(Arrays.asList(newX, newY)));
                }
            }
        }

        return distance;
    }
}