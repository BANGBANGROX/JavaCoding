import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private String word;

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private long countAtLeastK(int k) {
        long result = 0;
        final Map<Character, Integer> vowelsCount = new HashMap<>();
        int left = 0;
        int consonantsCount = 0;
        final int n = word.length();

        for (int right = 0; right < n; ++right) {
            if (isVowel(word.charAt(right))) {
                vowelsCount.put(word.charAt(right),
                        vowelsCount.getOrDefault(word.charAt(right), 0) + 1);
            } else {
                ++consonantsCount;
            }
            while (vowelsCount.size() >= 5 && consonantsCount >= k) {
                result += (n - right);
                if (isVowel(word.charAt(left))) {
                    vowelsCount.put(word.charAt(left), vowelsCount.get(word.charAt(left)) - 1);
                    if (vowelsCount.get(word.charAt(left)) == 0) {
                        vowelsCount.remove(word.charAt(left));
                    }
                } else {
                    --consonantsCount;
                }
                ++left;
            }
        }

        return result;
    }

    public long countOfSubstrings(String word, int k) {
        this.word = word;

        return countAtLeastK(k) - countAtLeastK(k + 1);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().countOfSubstrings(scanner.next(),
                   scanner.nextInt()));
       }
       
       scanner.close();
   }
}
