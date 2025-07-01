import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int substrCount(final String s, final int k) {
        // code here
        final int n = s.length();
        int answer = 0;

        for (int i = 0; i + k <= n; ++i) {
            final Set<Character> uniqueCharacters = new HashSet<>();
            final String substring = s.substring(i, i + k);
            for (final char ch : substring.toCharArray()) {
                uniqueCharacters.add(ch);
            }
            if (uniqueCharacters.size() == k - 1) {
                ++answer;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().substrCount(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
