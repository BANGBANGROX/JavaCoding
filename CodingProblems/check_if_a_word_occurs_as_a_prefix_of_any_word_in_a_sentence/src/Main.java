import java.util.Scanner;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int len = searchWord.length();
        int n = words.length;

        for (int i = 0; i < n; ++i) {
            if (words[i].length() < len) continue;
            int itr = 0;
            while (itr < len && words[i].charAt(itr) == searchWord.charAt(itr)) {
                ++itr;
            }
            if (itr == len) return i + 1;
        }

        return -1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().isPrefixOfWord(scanner.nextLine(), scanner.next()));
       }
       
       scanner.close();
   }
}
