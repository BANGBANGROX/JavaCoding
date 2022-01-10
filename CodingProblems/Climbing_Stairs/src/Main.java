import java.util.Scanner;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        if (n == 2) return 2;

        int first = 1, second = 2;

        for (int i = 3; i <= n; ++i) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution obj = new Solution();

            System.out.println(obj.climbStairs(n));
        }

        sc.close();
    }
}
