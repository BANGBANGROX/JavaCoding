import java.util.Scanner;

class Solution {
    public int maxDiff(final int num) {
        int answer = 0;
        final String numString = String.valueOf(num);

        for (char a1 = '0'; a1 <= '9'; ++a1) {
            for (char b1 = '0'; b1 <= '9'; ++b1) {
                final String firstReplacedNum = replace(a1, b1, numString);
                if (firstReplacedNum.charAt(0) == '0' || Integer.parseInt(firstReplacedNum) == 0) {
                    continue;
                }
                for (char a2 = '0'; a2 <= '9'; ++a2) {
                    for (char b2 = '0'; b2 <= '9'; ++b2) {
                        final String secondReplacedNum = replace(a2, b2, numString);
                        if (secondReplacedNum.charAt(0) == '0' || Integer.parseInt(secondReplacedNum) == 0) {
                            continue;
                        }
                        answer = Math.max(answer, Math.abs(Integer.parseInt(firstReplacedNum)
                                - Integer.parseInt(secondReplacedNum)));
                    }
                }
            }
        }

        return answer;
    }

    private String replace(final char a, final char b, final String s) {
        final StringBuilder newString = new StringBuilder();

        for (final char ch : s.toCharArray()) {
            if (ch == a) {
                newString.append(b);
            } else {
                newString.append(ch);
            }
        }

        return newString.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().maxDiff(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
