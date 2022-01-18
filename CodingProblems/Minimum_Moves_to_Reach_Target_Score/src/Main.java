import java.util.Scanner;

class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;

        while (maxDoubles != 0 && target > 1) {
            if (target % 2 == 1) {
                ++ans;
                --target;
            }
            target /= 2;
            ++ans;
            --maxDoubles;
        }

        ans += (target - 1);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int target = sc.nextInt();
            int maxDoubles = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minMoves(target, maxDoubles));
        }

        sc.close();
    }
}
