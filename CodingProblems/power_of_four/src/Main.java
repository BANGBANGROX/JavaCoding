import java.util.Scanner;

class Solution {
    public boolean isPowerOfFour(final int n) {
        if (n <= 0) {
            return false;
        }

        int num = n;

        while (num % 4 == 0) {
            num /= 4;
        }

        return num == 1;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().isPowerOfFour(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
