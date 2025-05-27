import java.util.Scanner;

class Solution {
    public int differenceOfSums(final int n, final int m) {
        final int divisibleNumCnt = n / m;

        return n - m * divisibleNumCnt * (divisibleNumCnt + 1);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int m = scanner.nextInt();

           System.out.println(new Solution().differenceOfSums(n, m));
       }
       
       scanner.close();
   }
}
