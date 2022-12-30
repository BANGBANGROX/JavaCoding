import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, Integer> length = new HashMap<>();
        int ans = 0;

        Arrays.sort(nums);

        for (int num : nums) {
            double numSqrt = Math.sqrt(num);
            if (numSqrt == Math.floor(numSqrt)) {
                length.put(num, length.getOrDefault((int) numSqrt, 0) + 1);
            }
            else {
                length.put(num, 1);
            }
            ans = Math.max(ans, length.get(num));
        }

        return ans < 2 ? -1 : ans;
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
            System.out.println(solution.longestSquareStreak(nums));
        }

        sc.close();
    }
}
