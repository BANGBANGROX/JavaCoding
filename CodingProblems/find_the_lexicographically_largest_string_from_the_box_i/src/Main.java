import java.util.Scanner;

class Solution {
    public String answerString(final String word, final int numFriends) {
        final int n = word.length();

        if (numFriends == 1) {
            return word;
        }

        String answer = "";

        for (int start = 0; start < n; ++start) {
            final int end;
            if (start >= numFriends - 1) {
                end = n - 1;
            } else {
                end = n - (numFriends - start);
            }
            final String current = word.substring(start, end + 1);
            if (answer.compareTo(current) < 0) {
                answer = current;
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
           System.out.println(new Solution().answerString(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
