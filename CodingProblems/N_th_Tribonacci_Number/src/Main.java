import java.util.Scanner;

class Solution {
    public int tribonacci(int n) {
       if (n == 0) return 0;

       if (n == 1) return 1;

       if (n == 2) return 1;

       int one = 0, two = 1, three = 1;

       for (int i = 3; i <= n; ++i) {
           int four = one + two + three;
           one = two;
           two = three;
           three = four;
       }

       return three;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution obj = new Solution();

            System.out.println(obj.tribonacci(n));
        }

        sc.close();
    }
}
