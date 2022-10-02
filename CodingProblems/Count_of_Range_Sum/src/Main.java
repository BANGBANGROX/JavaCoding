import java.util.Scanner;

class Solution {
    private int lower;
    private int upper;
    private long[] prefixSum;
    private int ans;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        this.lower = lower;
        this.upper = upper;
        ans = 0;
        prefixSum = new long[n + 1];

        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        mergeSort(0, n);

        return ans;
    }

    private void mergeSort(int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        int i = mid + 1;
        int j = mid + 1;

        for (int k = start; k <= mid; ++k) {
            while (i <= end && prefixSum[i] - prefixSum[k] < lower) ++i;
            while (j <= end && prefixSum[j] - prefixSum[k] <= upper) ++j;
            ans += (j - i);
        }

        merge(start, mid, end);
    }

    private void merge(int start, int mid, int end) {
        long[] temp = new long[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = start;

        if (end + 1 - start >= 0)
            System.arraycopy(prefixSum, start, temp, 0, end + 1 - start);

        while (i <= mid && j <= end) {
            if (temp[i - start] <= temp[j - start]) {
                prefixSum[k] = temp[i - start];
                ++i;
            } else {
                prefixSum[k] = temp[j - start];
                ++j;
            }
            ++k;
        }

        while (i <= mid) {
            prefixSum[k] = temp[i - start];
            ++i;
            ++k;
        }
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
            int lower = sc.nextInt();
            int upper = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countRangeSum(nums, lower, upper));
        }

        sc.close();
    }
}
