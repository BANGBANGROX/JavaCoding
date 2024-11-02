import java.util.Scanner;

class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n - 1; ++i) {
            String first = words[i];
            String second = words[i + 1];
            if (first.charAt(first.length() - 1) != second.charAt(0)) return false;
        }

        return words[n - 1].charAt(words[n - 1].length() - 1) == words[0].charAt(0);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().isCircularSentence(scanner.nextLine()));
       }
       
       scanner.close();
   }
}
