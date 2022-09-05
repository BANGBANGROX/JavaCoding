import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private final ArrayList<Integer> ans = new ArrayList<>();

    private void generate(int number, int n, int k, int previousDigit) {
        if (n == 0) {
            ans.add(number);
            return;
        }

        if (previousDigit - k >= 0)
            generate(number * 10 + (previousDigit - k), n - 1, k,
                    previousDigit - k);

        if (k != 0 && previousDigit + k <= 9)
            generate(number * 10 + (previousDigit + k), n - 1, k,
                previousDigit + k);
    }

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; ++i) {
            generate(i, n - 1, k, i);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            int[] ans = solution.numsSameConsecDiff(n, k);
            for (int x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
