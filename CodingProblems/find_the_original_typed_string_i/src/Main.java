import java.util.Scanner;

class Solution {
    public int possibleStringCount(final String word) {
        int answer = 1;
        char lastChar = '#';
        int currentCount = 0;

        for (final char ch : word.toCharArray()) {
            if (ch == lastChar) {
                ++currentCount;
            } else {
                if (currentCount > 1) {
                    answer += (currentCount - 1);
                }
                lastChar = ch;
                currentCount = 1;
            }
        }

        if (currentCount > 1) {
            answer += (currentCount - 1);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
       }
       
       scanner.close();
   }
}
