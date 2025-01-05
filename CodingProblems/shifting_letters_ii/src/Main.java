import java.util.Scanner;

class Solution {
    private char getFinalCharacter(char oldChar, int difference) {
        char result = oldChar;
        int numShifts = Math.abs(difference) % 26;

        if (difference < 0) {
            while (numShifts > 0) {
                if (result == 'a') {
                    result = 'z';
                } else {
                    --result;
                }
                --numShifts;
            }
        } else {
            while (numShifts > 0) {
                if (result == 'z') {
                    result = 'a';
                } else {
                    ++result;
                }
                --numShifts;
            }
        }

        return result;
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] difference = new int[n + 1];
        StringBuilder answer = new StringBuilder();

        for (int[] shift : shifts) {
            int left = shift[0];
            int right = shift[1];
            int type = shift[2];
            if (type == 0) {
                --difference[left];
                ++difference[right + 1];
            } else {
                ++difference[left];
                --difference[right + 1];
            }
        }

        for (int i = 1; i <= n; ++i) {
            difference[i] += difference[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            answer.append(getFinalCharacter(s.charAt(i), difference[i]));
        }

        return answer.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           String s = scanner.next();
           int n = scanner.nextInt();
           int[][] shifts = new int[n][3];
           for (int i = 0; i < n; ++i) {
               shifts[i][0] = scanner.nextInt();
               shifts[i][1] = scanner.nextInt();
               shifts[i][2] = scanner.nextInt();
           }

           System.out.println(new Solution().shiftingLetters(s, shifts));
       }
       
       scanner.close();
   }
}
