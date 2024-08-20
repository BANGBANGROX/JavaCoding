import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private boolean isDivisibleBy7(char[] num) {
        int rem = 0;

        for (char c : num) {
            rem = (rem * 10 + c - '0') % 7;
        }

        return rem == 0;
    }

    public String largestPalindrome(int n, int k) {
        if (n == 1) {
            if (k == 1 || k == 3 || k == 9) return "9";
            else if (k == 2 || k == 4 || k == 8) return "8";
            else if (k == 5) return "5";
            else if (k == 6) return "6";
            else return "7";
        } else if (n == 2) {
            if (k == 1 || k == 3 || k == 9) return "99";
            else if (k == 2 || k == 4 || k == 8) return "88";
            else if (k == 5) return "55";
            else if (k == 6) return "66";
            else return "77";
        } else if (n == 3) {
            if (k == 1 || k == 3 || k == 9) return "999";
            else if (k == 2) return "898";
            else if (k == 4 || k == 8) return "888";
            else if (k == 5) return "595";
            else if (k == 6) return "888";
            else return "959";
        } else if (n == 4) {
            if (k == 1 || k == 3 || k == 9) return "9999";
            else if (k == 2) return "8998";
            else if (k == 4 || k == 8) return "8888";
            else if (k == 5) return "5995";
            else if (k == 6) return "8778";
            else return "9779";
        } else {
            char[] answer = new char[n];

            Arrays.fill(answer, '9');

            if (k == 1 || k == 3 || k == 9) return new String(answer);

            if (k == 2) {
                answer[0] = answer[n - 1] = '8';
                return new String(answer);
            }

            if (k == 4) {
                answer[0] = answer[n - 1] = answer[1] = answer[n - 2] = '8';
                return new String(answer);
            }

            if (k == 5) {
                answer[0] = answer[n - 1] = '5';
                return new String(answer);
            }

            if (k == 6) {
                int digitSum = 9 * n;
                answer[n - 1] = answer[0] = '8';
                digitSum -= 2;

                if (digitSum % 3 != 0) {
                    if ((n & 1) > 0) {
                        --answer[n / 2];
                    } else {
                        answer[n / 2] -= 2;
                        answer[(n / 2) - 1] -= 2;
                    }
                }

                return new String(answer);
            }

            if (k == 7) {
                for (char digit = '9'; digit >= '0'; --digit) {
                    if ((n & 1) > 0) {
                        answer[n / 2] = digit;
                    } else {
                        answer[n / 2] = digit;
                        answer[(n / 2) - 1] = digit;
                    }
                    if (isDivisibleBy7(answer)) return new String(answer);
                }
            }

            if (k == 8) {
                answer[0] = answer[n - 1] = answer[1] = answer[n - 2] = answer[2] =
                        answer[n - 3] = '8';

                return new String(answer);
            }
        }

        return "";
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().largestPalindrome(scanner.nextInt(),
                   scanner.nextInt()));
       }
   }
}
