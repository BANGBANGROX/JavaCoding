import java.util.Scanner;

class Solution {
    public int subarraySum(final int[] arr) {
        // code here
        int answer = 0;
        final int n = arr.length;

        for (int i = 0; i < n; ++i) {
            final int right = n - i;
            answer += arr[i] * (i + right + i * (right - 1));
        }

        return answer;
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

           System.out.println(new Solution().subarraySum(arr));
       }
       
       scanner.close();
   }
}
