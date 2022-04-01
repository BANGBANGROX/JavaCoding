import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
         int m = maze.length;
         int n = maze[0].length;
         int length = 1;
         int[] dx = {1, 0, -1, 0};
         int[] dy = {0, -1, 0, 1};
         Queue<Pair> q = new LinkedList<>();

         q.add(new Pair(entrance[0], entrance[1]));
         maze[entrance[0]][entrance[1]] = '+';

         while (!q.isEmpty()) {
             int size = q.size();
             for (int i = 0; i < size; ++i) {
                 assert  q.peek() != null;
                 int x = q.peek().first;
                 int y = q.peek().second;
                 q.poll();
                 for (int j = 0; j < 4; ++j) {
                     int newX = x + dx[j];
                     int newY = y + dy[j];
                     if (newX >= 0 && newY >= 0 && newX < m && newY < n && maze[newX][newY] == '.') {
                         if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) return length;
                         q.add(new Pair(newX, newY));
                         maze[newX][newY] = '+';
                     }
                 }
             }
             ++length;
         }

         return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] maze = new char[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    maze[i][j] = sc.next().charAt(0);
                }
            }
            int[] entrance = new int[2];
            entrance[0] = sc.nextInt();
            entrance[1] = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.nearestExit(maze, entrance));
        }

        sc.close();
    }
}
