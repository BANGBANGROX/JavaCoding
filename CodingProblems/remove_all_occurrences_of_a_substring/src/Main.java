import java.util.Scanner;

class Solution {
    private String part;
    private char[] currentS;

    private boolean search(int left, int right) {
        for (int i = left; i <= right; ++i) {
            if (part.charAt(i - left) != currentS[i]) {
                return false;
            }
        }

        return true;
    }

    public String removeOccurrences(String s, String part) {
        if (part.length() > s.length()) return s;

        currentS = s.toCharArray();
        this.part = part;
        int left = 0;
        int right = part.length() - 1;

        while (right < currentS.length) {
            if (search(left, right)) {
                StringBuilder newS = new StringBuilder();
                for (int i = 0; i < currentS.length; ++i) {
                    if (i < left || i > right) {
                        newS.append(currentS[i]);
                    }
                }
                currentS = newS.toString().toCharArray();
                left = 0;
                right = part.length() - 1;
            } else {
                ++left;
                ++right;
            }
        }

        return new String(currentS);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().removeOccurrences(scanner.next(), scanner.next()));
       }
       
       scanner.close();
   }
}
