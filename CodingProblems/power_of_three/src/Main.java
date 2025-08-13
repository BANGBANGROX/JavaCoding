import java.util.Scanner;

class Solution {
    private static final int MAX_VALUE = 1162261467;

    public boolean isPowerOfThree(final int n) {
        return n > 0 && MAX_VALUE % n == 0;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().isPowerOfThree(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
