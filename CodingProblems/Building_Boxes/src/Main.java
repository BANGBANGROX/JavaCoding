import java.util.Scanner;

class Solution {
    public int minimumBoxes(int n) {
        int current = 0;
        int side = 0;
        int extra = 0;

        while (current + (side + 1) * (side + 2) / 2 <= n) {
            current += (side + 1) * (side + 2) / 2;
            ++side;
        }

        while (current < n) {
            ++extra;
            current += extra;
        }

        return side * (side + 1) / 2 + extra;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumBoxes(n));
        }

        sc.close();
    }
}
