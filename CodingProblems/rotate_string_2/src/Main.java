import java.util.Scanner;

class Solution {
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();

        if (m != n) return false;

        return (s + s).contains(goal);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().rotateString(scanner.next(), scanner.next()));
       }
       
       scanner.close();
   }
}
