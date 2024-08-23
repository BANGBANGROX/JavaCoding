import java.util.Scanner;

class Solution {
    private int calculateGCD(int a, int b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    public String fractionAddition(String expression) {
        int lastNumerator = Integer.MIN_VALUE;
        int lastDenominator = Integer.MAX_VALUE;
        int n = expression.length();

        for (int i = 0; i < n; ++i) {
            StringBuilder numeratorString = new StringBuilder();
            StringBuilder denominatorString = new StringBuilder();
            int sign = 1;
            if (!Character.isDigit(expression.charAt(i))) {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                ++i;
            }
            while (i < n && Character.isDigit(expression.charAt(i))) {
                numeratorString.append(expression.charAt(i));
                ++i;
            }
            ++i;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denominatorString.append(expression.charAt(i));
                ++i;
            }
            int numerator = sign * Integer.parseInt(numeratorString.toString());
            int denominator = Integer.parseInt(denominatorString.toString());
            if (lastNumerator != Integer.MIN_VALUE) {
                int newNumerator = numerator * lastDenominator + lastNumerator * denominator;
                int newDenominator = lastDenominator * denominator;
                lastNumerator = newNumerator ;
                lastDenominator = newDenominator;
            } else {
                lastNumerator = numerator;
                lastDenominator = denominator;
            }
            int gcd = calculateGCD(Math.abs(lastNumerator), Math.abs(lastDenominator));
            lastNumerator /= gcd;
            lastDenominator /= gcd;
            --i;
        }

        return lastNumerator + "/" + lastDenominator;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().fractionAddition(scanner.next()));
       }
   }
}
