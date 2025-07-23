import java.util.Scanner;

class Solution {
    private record Pair(String s, int gain) {
    }

    public int maximumGain(final String s, final int x, final int y) {
        final String first;
        final String second;
        final int firstCost;
        final int secondCost;

        if (x > y) {
            first = "ab";
            second = "ba";
            firstCost = x;
            secondCost = y;
        } else {
            first = "ba";
            second = "ab";
            firstCost = y;
            secondCost = x;
        }

        final Pair firstPair = maximumGainHandler(first, firstCost, s);
        final Pair secondPair = maximumGainHandler(second, secondCost, firstPair.s);

        return firstPair.gain + secondPair.gain;
    }

    private Pair maximumGainHandler(final String lookupString, final int gain, final String s) {
        int result = 0;
        final StringBuilder stack = new StringBuilder();

        for (final char ch : s.toCharArray()) {
            if (!stack.isEmpty() && lookupString.charAt(1) == ch && stack.charAt(stack.length() - 1) ==
                    lookupString.charAt(0)) {
                result += gain;
                stack.setLength(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }

        return new Pair(stack.toString(), result);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
       }
       
       scanner.close();
   }
}
