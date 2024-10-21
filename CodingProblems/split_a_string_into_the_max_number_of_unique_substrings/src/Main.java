import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int answer;
    private Set<String> visited;
    private String s;

    private void generateSubstrings(int idx, int cnt) {
        if (idx >= s.length()) {
            answer = Math.max(answer, cnt);
        }

        StringBuilder currentStringBuilder = new StringBuilder();

        for (int i = idx; i < s.length(); ++i) {
            currentStringBuilder.append(s.charAt(i));
            if (!visited.contains(currentStringBuilder.toString())) {
                visited.add(currentStringBuilder.toString());
                generateSubstrings(i + 1, cnt + 1);
                visited.remove(currentStringBuilder.toString());
            }
        }
    }

    public int maxUniqueSplit(String s) {
        answer = 0;
        visited = new HashSet<>();
        this.s = s;

        generateSubstrings(0, 0);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().maxUniqueSplit(scanner.next()));
       }
       
       scanner.close();
   }
}
