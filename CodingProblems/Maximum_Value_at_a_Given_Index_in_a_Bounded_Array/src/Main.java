import java.util.Scanner;

class Solution {
    private long lesserValue(int value, int index) {
         // value < index + 1
        long difference = (index - value + 1);
        long sum = (long) value * (value + 1) / 2;

        return difference + sum;
    }

    private long greaterValue(int value, int index) {
        // value > index + 1
        long a = value - index;
        long n = index + 1;

        return n * (2 * a + n - 1) / 2;
    }

    private boolean check(int n, int value, int maxSum, int index) {
        long leftSum;
        long rightSum;
        int rightIndex = n - index - 1;

        if (value <= index + 1) leftSum = lesserValue(value, index);
        else leftSum = greaterValue(value, index);

        if (value - 1 <= rightIndex) rightSum = lesserValue(value - 1, rightIndex);
        else rightSum = greaterValue(value - 1, rightIndex);

        return (leftSum + rightSum) <= maxSum;
    }

    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        int ans = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(n, mid, maxSum, index)) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
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
            int index = sc.nextInt();
            int maxSum = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maxValue(n, index, maxSum));
        }

        sc.close();
    }
}
