import java.util.Scanner;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;

        int n = nums.length;
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];
        int[] answer = new int[n];

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = n - 2; i >= 0; --i) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        for (int i = 0; i < n; ++i) {
            int left = i - k;
            int right = i + k;
            if (left < 0 || right >= n) {
                answer[i] = -1;
                continue;
            }
            long leftSum = left > 0 ? prefixSum[i] - prefixSum[left - 1] : prefixSum[i];
            long rightSum = right < n - 1 ? suffixSum[i] - suffixSum[right + 1] : suffixSum[i];
            long totalSum = leftSum + rightSum - nums[i];
            answer[i] = (int) (totalSum / (right - left + 1));
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
            int[] answer = solution.getAverages(nums, k);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
