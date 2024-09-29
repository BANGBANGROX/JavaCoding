import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");
        Map<String, Integer> count = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (String word : s1Words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (String word : s2Words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                answer.add(entry.getKey());
            }
        }

        return answer.toArray(new String[0]);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           String[] answer = new Solution().uncommonFromSentences(scanner.next(),
                   scanner.next());
           for (String s : answer) {
               System.out.print(s + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}