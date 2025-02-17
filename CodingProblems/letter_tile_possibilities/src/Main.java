import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int[] count;
    private int answer;
    private Set<String> visited;

    private void generate(int charsRemaining, String current) {
        if (charsRemaining == 0) {
            if (visited.add(current)) {
                ++answer;
            }
            return;
        }

        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            if (count[ch - 'A'] > 0) {
                --count[ch - 'A'];
                generate(charsRemaining - 1, current + ch);
                ++count[ch - 'A'];
            }
        }
    }

    public int numTilePossibilities(String tiles) {
        count = new int[26];
        visited = new HashSet<>();
        answer = 0;
        int n = tiles.length();

        for (char ch : tiles.toCharArray()) {
            ++count[ch - 'A'];
        }

        for (int i = 1; i <= n; ++i) {
            generate(i, "");
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().numTilePossibilities(scanner.next()));
       }
       
       scanner.close();
   }
}
