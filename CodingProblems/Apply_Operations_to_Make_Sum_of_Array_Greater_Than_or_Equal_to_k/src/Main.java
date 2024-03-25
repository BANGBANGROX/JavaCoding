import java.util.Scanner;

class Solution {
    public int minOperations(int k) {
        if (k == 1) return 0;

        for (int i = 1; i <= k; ++i) {
            int halfSteps = i / 2;
            if ((i - halfSteps + 1) * (halfSteps + 1) >= k) return i;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minOperations(k));
        }

        sc.close();
    }
}
