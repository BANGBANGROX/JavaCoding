import java.util.Scanner;

class Solution {
    public boolean isValid(final String word) {
        if (word.length() < 3) {
            return false;
        }

        int vowels = 0;
        int consonants = 0;

        for (final char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }

            if (Character.isAlphabetic(ch)) {
                final char lowerCh = Character.toLowerCase(ch);

                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                    ++vowels;
                } else {
                    ++consonants;
                }
            }
        }

        return vowels > 0 && consonants > 0;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().isValid(scanner.next()));
       }
       
       scanner.close();
   }
}
