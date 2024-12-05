import java.util.Scanner;

class Solution {
    public boolean canChange(String start, String target) {
       int n = start.length();
       int i = 0;
       int j = 0;

       while (i < n || j < n) {
           while (i < n && start.charAt(i) == '_') {
               ++i;
           }
           while (j < n && target.charAt(j) == '_') {
               ++j;
           }
           if (i == n || j == n) {
               return i == n && j == n;
           }
           if (start.charAt(i) != target.charAt(i) || (start.charAt(i) == 'L' && i < j)
                   || (start.charAt(i) == 'R' && i > j)) return false;
           ++i;
           ++j;
       }

       return true;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().canChange(scanner.next(), scanner.next()));
       }
       
       scanner.close();
   }
}
