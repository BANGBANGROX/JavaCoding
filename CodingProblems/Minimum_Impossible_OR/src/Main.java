import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minImpossibleOR(int[] nums) {
        int minValue = Arrays.stream(nums).min().getAsInt();

        if (minValue > 1) return 1;

        int bit = 0;

        for (; bit < 32; ++bit) {
            boolean flag = true;
            for (int num : nums) {
                if (num == (1 << bit)) {
                    flag = false;
                    break;
                }
            }
            if (flag) break;
        }

        return (1 << bit);
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
            System.out.println(solution.minImpossibleOR(nums));
        }

        sc.close();
    }
}
