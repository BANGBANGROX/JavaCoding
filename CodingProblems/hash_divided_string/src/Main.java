import java.util.Scanner;

class Solution {
    public String stringHash(String s, int k) {
        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int currentHash = 0;
        final int MOD = 26;

        for (int i = 0; i < n; ++i) {
            if (i > 0 && i % k == 0) {
                answer.append((char) (currentHash + 'a'));
                currentHash = 0;
            } else {
                currentHash = (currentHash + s.charAt(i) - 'a') % MOD;
            }
        }

        return answer.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().stringHash(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
