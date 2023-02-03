import java.util.Scanner;

class Solution {
    public String convert(String s, int numRows) {
         if (numRows == 1) return s;

         StringBuilder ans = new StringBuilder();
         int charsInSection = 2 * numRows - 1;
         int n = s.length();

         for (int currentRow = 0; currentRow < numRows; ++currentRow) {
             int index = currentRow;
             while (index < n) {
                 ans.append(s.charAt(index));
                 if (currentRow != 0 && currentRow != numRows - 1) {
                     int charsInBetween = charsInSection - 2 * currentRow;
                     int secondIndex = index + charsInBetween;
                     if (secondIndex < n) {
                         ans.append(s.charAt(secondIndex));
                     }
                 }
                 index += charsInSection;
             }
         }

         return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int numRows = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.convert(s, numRows));
        }

        sc.close();
    }
}
