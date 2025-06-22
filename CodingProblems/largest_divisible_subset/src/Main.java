import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public ArrayList<Integer> largestSubset(final int[] arr) {
        // code here
        final int n = arr.length;
        final int[] dp = new int[n];
        final int[] nextIndex = new int[n];
        final ArrayList<Integer> answer = new ArrayList<>();
        int startingPoint = 0;

        Arrays.sort(arr);
        reverse(arr);

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            nextIndex[i] = i;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (arr[i] % arr[j] == 0) {
                    if (dp[j] < dp[i] + 1) {
                        dp[j] = dp[i] + 1;
                        nextIndex[j] = i;
                    }
                }
            }
            if (dp[i] > dp[startingPoint]) {
                startingPoint = i;
            }
        }

        while (nextIndex[startingPoint] != startingPoint) {
            answer.add(arr[startingPoint]);
            startingPoint = nextIndex[startingPoint];
        }

        answer.add(arr[startingPoint]);

        return answer;
    }

    private void reverse(final int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            arr[left] += arr[right];
            arr[right] = arr[left] - arr[right];
            arr[left] -= arr[right];
            ++left;
            --right;
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

           System.out.println(new Solution().largestSubset(arr));
       }
       
       scanner.close();
   }
}
