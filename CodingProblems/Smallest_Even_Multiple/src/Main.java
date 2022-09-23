import java.util.Scanner;

class Solution {
    public int smallestEvenMultiple(int n) {
        return (n & 1) == 0 ? n : n * 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.smallestEvenMultiple(n));
        }

        sc.close();
    }
}
