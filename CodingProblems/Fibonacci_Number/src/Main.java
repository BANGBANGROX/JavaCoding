import java.util.Scanner;

class Solution {
    public int fib(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        int one = 0, two = 1;

        for (int i = 2; i <= n; ++i) {
            int three = one + two;
            one = two;
            two = three;
        }

        return two;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();

            System.out.println(obj.fib(n));
        }
    }
}
