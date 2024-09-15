import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private int convertToBitmask(boolean[] arr) {
        int result = 0;

        for (boolean val : arr) {
            result *= 2;
            if (val) ++result;
        }

        return result;
    }

    public int findTheLongestSubstring(String s) {
        boolean[] isOdd = new boolean[5];
        String vowelString = "aeiou";
        Map<Integer, Integer> lastIndexOfMask = new HashMap<>();
        int answer = 0;
        int n = s.length();

        lastIndexOfMask.put(0, 0);

        for (int i = 0; i < n; ++i) {
            int idx = vowelString.indexOf(s.charAt(i));
            if (idx != -1) {
                isOdd[idx] = !isOdd[idx];
            }
            int mask = convertToBitmask(isOdd);
            if (lastIndexOfMask.containsKey(mask)) {
                answer = Math.max(answer, i - lastIndexOfMask.get(mask) + 1);
            } else {
                lastIndexOfMask.put(mask, i + 1);
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().findTheLongestSubstring(scanner.next()));
       }
       
       scanner.close();
   }
}
