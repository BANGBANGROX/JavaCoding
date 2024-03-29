import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        int currentLevel = 0;
        int answer = 0;

        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            int cnt = 1;
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                ++cnt;
                ++i;
            }
            answer += currentLevel * cnt;
            ++currentLevel;
        }

        return answer;
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
            System.out.println(solution.reductionOperations(nums));
        }

        sc.close();
    }
}
