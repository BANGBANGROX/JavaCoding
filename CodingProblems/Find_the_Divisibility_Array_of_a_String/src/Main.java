import java.util.Scanner;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long num = 0;

        for (int i = 0; i < n; ++i) {
            num = (num * 10 + word.charAt(i) - '0') % m;
            if (num == 0) ans[i] = 1;
            else ans[i] = 0;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String word = sc.next();
            int m = sc.nextInt();

            Solution solution = new Solution();
            int[] ans = solution.divisibilityArray(word, m);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
