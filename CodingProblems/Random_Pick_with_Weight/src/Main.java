class Solution {
    private final int[] prefixSum;

    public Solution(int[] w) {
        int n = w.length;
        prefixSum = new int[n];

        prefixSum[0] = w[0];

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    private int upperBound(int key) {
        int n = prefixSum.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = (l + ((r - l) >> 1));
            if (prefixSum[mid] <= key) l = mid + 1;
            else r = mid;
        }

        return l;
    }

    public int pickIndex() {
        int n = prefixSum.length;
        int key = (int)(Math.random() * (prefixSum[n - 1]));

        return upperBound(key);
    }
}


public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3};

        Solution solution = new Solution(nums);
        System.out.println(solution.pickIndex()); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
        System.out.println(solution.pickIndex()); // return 1
        System.out.println(solution.pickIndex()); // return 1
        System.out.println(solution.pickIndex()); // return 1
        System.out.println(solution.pickIndex());
        // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
    }
}
