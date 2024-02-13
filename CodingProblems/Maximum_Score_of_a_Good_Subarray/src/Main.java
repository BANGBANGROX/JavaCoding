import java.util.Scanner;

class Solution {
    public int maximumScore(int[] nums, int k) {
        int l = k;
        int r = k;
        int minValue = nums[k];
        int answer = nums[k];
        int n = nums.length;

        while (l > 0 || r < n - 1) {
            if (l == 0 || (r < n - 1 && nums[r + 1] > nums[l - 1])) {
                ++r;
            }
            else {
                --l;
            }
            minValue = Math.min(minValue, Math.min(nums[l], nums[r]));
            answer = Math.max(answer, minValue * (r - l + 1));
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maximumScore(nums, k));
        }

        sc.close();
    }
}
