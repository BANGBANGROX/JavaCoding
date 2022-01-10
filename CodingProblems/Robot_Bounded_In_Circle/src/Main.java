import java.util.Scanner;

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int n = instructions.length();
        int dir = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; ++i) {
            char ins = instructions.charAt(i);
            if (ins == 'G') {
                x += dx[dir];
                y += dy[dir];
            }
            else if (ins == 'L') dir = (dir + 1) % 4;
            else dir = (dir + 3) % 4;
        }

        return (x == 0 && y == 0) || dir > 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String instructions = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.isRobotBounded(instructions));
        }

        sc.close();
    }
}
