import java.util.Scanner;

class Solution {
    public boolean isStrictlyPalindromic(int n) {
         return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.isStrictlyPalindromic(n));
        }

        sc.close();
    }
}
