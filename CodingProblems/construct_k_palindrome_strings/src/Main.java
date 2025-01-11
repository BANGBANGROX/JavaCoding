import java.util.Scanner;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;

        int[] count = new int[26];
        int oddCntChars = 0;

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        for (int val : count) {
            if ((val & 1) > 0) {
                ++oddCntChars;
            }
        }

        return oddCntChars <= k;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           String s = scanner.next();
           int k = scanner.nextInt();

           System.out.println(new Solution().canConstruct(s, k));
       }
       
       scanner.close();
   }
}
