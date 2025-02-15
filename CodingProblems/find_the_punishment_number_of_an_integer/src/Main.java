import java.util.Scanner;

class Solution {
    private int requiredNum;
    private String squaredNumString;

    private boolean check(int idx, int currentNum, int totalSum) {
        if (idx == squaredNumString.length()) {
            totalSum += currentNum;
            return totalSum == requiredNum;
        }

        return check(idx + 1, currentNum * 10 + squaredNumString.charAt(idx) -
                '0', totalSum) || check(idx + 1, squaredNumString.charAt(idx) -
                '0', totalSum + currentNum);
    }

    public int punishmentNumber(int n) {
        int answer = 0;

        for (int i = 1; i <= n; ++i) {
            int squaredNum = i * i;
            requiredNum = i;
            squaredNumString = String.valueOf(squaredNum);
            if (check(0, 0, 0)) {
                answer += squaredNum;
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
           System.out.println(new Solution().punishmentNumber(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
