import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);
        arr[0] = Math.min(arr[0], 1);

        for (int i = 1; i < n; ++i) {
            if (arr[i] > arr[i - 1] + 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maximumElementAfterDecrementingAndRearranging(arr));
        }

        sc.close();
    }
}
