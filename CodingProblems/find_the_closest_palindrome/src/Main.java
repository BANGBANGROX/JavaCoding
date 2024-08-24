import java.util.Scanner;

class Solution {
    private long buildPalindromeNumber(String n, boolean isLenEven) {
        StringBuilder reversedNum = new StringBuilder(n).reverse();
        String palindromeNum = n + (isLenEven ? reversedNum : reversedNum.deleteCharAt(0));

        return Long.parseLong(palindromeNum);
    }

    private boolean isAll9String(String n) {
        for (char dig : n.toCharArray()) {
            if (dig != '9') return false;
        }

        return true;
    }

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        // Edge cases

        // Case 1: Number <= 10 or Number like 10, 100, 1000... then answer is num - 1
        if (num <= 10 || (num % 10 == 0 && n.charAt(0) == '1' && Long.parseLong(n.substring(1)) == 0)) {
            return String.valueOf(num - 1);
        }

        // Case 2: Number == 11 or Number like 101, 1001, 10001... then answer is num - 2
        if (num == 11 || (num % 10 == 1 && n.charAt(0) == '1' && Long.parseLong(n.substring(1, len - 1)) == 0)) {
            return String.valueOf(num - 2);
        }

        // Case 3: Number consists of all 9s then answer is num + 2
        if (isAll9String(n)) {
            return String.valueOf(num + 2);
        }

        boolean isLenEven = ((len & 1) == 0);
        // palindromeRoot is half of the given string
        // 8990 -> 89
        // 89912 -> 899
        String palindromeRootStr = (isLenEven ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1));
        long palindromeRoot = Long.parseLong(palindromeRootStr);

        // smallerPalindromeNum will be a palindrome number smaller than num hence considering
        // palindromeRoot - 1 as its first half
        long smallerPalindromeNum = buildPalindromeNumber(String.valueOf(palindromeRoot - 1),
                isLenEven);
        long smallerDiff = Math.abs(num - smallerPalindromeNum);

        // equalPalindromeNum will be a palindrome number equal to num if num is a palindrome
        // otherwise just bigger or just smaller than num hence considering palindromeRoot as
        // its first half
        long equalPalindromeNum = buildPalindromeNumber(String.valueOf(palindromeRoot),
                isLenEven);
        long equalDiff = Math.abs(num - equalPalindromeNum);

        // biggerPalindromeNum will be a palindrome number bigger than num hence considering palindromeRoot + 1 as its first half
        long biggerPalindromeNum = buildPalindromeNumber(String.valueOf(palindromeRoot + 1),
                isLenEven);
        long biggerDiff = Math.abs(num - biggerPalindromeNum);

        // Computing final result
        long closestNum = (smallerDiff <= biggerDiff ? smallerPalindromeNum : biggerPalindromeNum);
        long minDiff = Math.min(smallerDiff, biggerDiff);

        // equalPalindromeNum != num
        if (equalDiff > 0) {
            if (equalDiff < minDiff) {
                closestNum = equalPalindromeNum;
            } else if (equalDiff == minDiff) {
                closestNum = Math.min(closestNum, equalPalindromeNum);
            }
        }

        return String.valueOf(closestNum);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().nearestPalindromic(scanner.next()));
       }

       scanner.close();
   }
}
