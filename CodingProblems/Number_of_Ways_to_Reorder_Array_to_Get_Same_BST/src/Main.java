import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private long[][] table;
    private final int MOD = (int) 1e9 + 7;

    private long numOfWaysHandler(ArrayList<Integer> numsList) {
        int n = numsList.size();

        if (n < 3) return 1;

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int i = 1; i < n; ++i) {
            if (numsList.get(i) < numsList.get(0)) {
                leftList.add(numsList.get(i));
            }
            else {
                rightList.add(numsList.get(i));
            }
        }

        long leftResult = numOfWaysHandler(leftList);
        long rightResult = numOfWaysHandler(rightList);

        return (((leftResult * rightResult) % MOD) *
                table[n - 1][leftList.size()]) % MOD;
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;
        table = new long[n][n];
        ArrayList<Integer> numsList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            table[i][0] = table[i][i] = 1;
            numsList.add(nums[i]);
        }

        for (int i = 2; i < n; ++i) {
            for (int j = 1; j < i; ++j) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }

        return ((int) numOfWaysHandler(numsList) - 1 + MOD) % MOD;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.numOfWays(nums));
        }

        sc.close();
    }
}
