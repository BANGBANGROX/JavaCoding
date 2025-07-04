import java.util.Scanner;

class Solution {
    public char kthCharacter(long k, final int[] operations) {
        int answer = 0;

        while (k > 1) {
            int leftBits = 63 - Long.numberOfLeadingZeros(k);
            if ((1L << leftBits) == k) {
                --leftBits;
            }
            k -= (1L << leftBits);
            if (operations[leftBits] == 1) {
                ++answer;
            }
        }

        return (char) ('a' + answer % 26);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int k = scanner.nextInt();
           final int n = scanner.nextInt();
           final int[] operations = new int[n];
           for (int i = 0; i < n; ++i) {
               operations[i] = scanner.nextInt();
           }

           System.out.println(new Solution().kthCharacter(k, operations));
       }
       
       scanner.close();
   }
}
