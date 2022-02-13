import java.util.*;

class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int ans = 0;
        int i = n - 1;

        Arrays.sort(cost);

        while (i >= 0) {
            ans += cost[i];
            if (i - 1 >= 0) ans += cost[i + 1];
            i -= 2;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; ++i) {
                cost[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.minimumCost(cost));
        }

        sc.close();
    }
}
