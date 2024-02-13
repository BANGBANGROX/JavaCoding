import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int getWinner(int[] arr, int k) {
         if (k == 1) {
             return Math.max(arr[0], arr[1]);
         }

         int n = arr.length;

         assert n > 0;

         if (k >= n) {
             return Arrays.stream(arr).max().getAsInt();
         }

         int currentWinner = arr[0];
         int winCount = 0;

         for (int i = 1; i < n; ++i) {
             if (currentWinner > arr[i]) {
                 ++winCount;
             }
             else {
                 currentWinner = arr[i];
                 winCount = 1;
             }
             if (winCount == k) return currentWinner;
         }

         return currentWinner;
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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.getWinner(arr, k));
        }

        sc.close();
    }
}
