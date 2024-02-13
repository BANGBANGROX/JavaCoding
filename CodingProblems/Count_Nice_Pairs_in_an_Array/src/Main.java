import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private int getNumberReverse(int num) {
        int result = 0;

        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }

    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        long answer = 0;
        final int MOD = (int) 1e9 + 7;

        for (int num : nums) {
            int diff = num - getNumberReverse(num);
            count.put(diff, count.getOrDefault(diff, 0) + 1);
        }

        for (int diff : count.keySet()) {
            long cnt = count.get(diff);
            answer = (answer + (cnt * (cnt - 1)) / 2) % MOD;
        }

        return (int) answer;
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
            System.out.println(solution.countNicePairs(nums));
        }

        sc.close();
    }
}
