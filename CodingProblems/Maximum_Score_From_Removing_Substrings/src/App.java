import java.util.Scanner;

class Solution {
    private static class Pair {
        String first;
        int second;

        Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private Pair getScore(String topString, int topScore, String s) {
        int result = 0;
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (topString.charAt(1) == ch && stack.length() > 0 && stack.charAt(stack.length() - 1) == topString.charAt(0)) {
                result += topScore;
                stack.setLength(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }

        return new Pair(stack.toString(), result);
    } 

    public int maximumGain(String s, int x, int y) {
        String topString;
        String botString;
        int topScore;
        int botScore;
        int answer = 0;
        
        if (x > y) {
            topString = "ab";
            botString = "ba";
            topScore = x;
            botScore = y;
        } else {
            topString = "ba";
            topScore = y;
            botString = "ab";
            botScore = x;
        }

        Pair topResult = getScore(topString, topScore, s);

        answer += topResult.second;
        answer += getScore(botString, botScore, topResult.first).second;


        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().maximumGain(scanner.next(), scanner.nextInt(), scanner.nextInt()));
        }

        scanner.close();
    }
}
