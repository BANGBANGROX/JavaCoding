import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {
    public void rearrange(int[] arr, final int x) {
        // code here
        final List<Integer> sortedArr = new ArrayList<>();

        for (final int num : arr) {
            sortedArr.add(num);
        }

        sortedArr.sort(Comparator.comparingInt(a -> Math.abs(x - a)));

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sortedArr.get(i);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            final int n = scanner.nextInt();
            final int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            final int x = scanner.nextInt();

            new Solution().rearrange(arr, x);

            for (final int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
