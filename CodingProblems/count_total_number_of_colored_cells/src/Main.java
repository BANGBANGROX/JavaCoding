import java.util.Scanner;

class Solution {
    public long coloredCells(int n) {
        return 2L * n * (n - 1) + 1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().coloredCells(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
