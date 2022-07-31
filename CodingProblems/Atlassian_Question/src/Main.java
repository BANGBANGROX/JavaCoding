import java.util.Scanner;

class Solution {
    public int findInt(int num) {
        String stringNum = String.valueOf(num);
        StringBuilder maxNum = new StringBuilder();
        StringBuilder minNum = new StringBuilder();
        char firstNonNine = '#';
        char secondNonZero = '#';
        char firstLetter = stringNum.charAt(0);

        for (char ch : stringNum.toCharArray()) {
            if (ch != '9') {
                firstNonNine = ch;
                break;
            }
        }

        for (char ch : stringNum.toCharArray()) {
            if (ch != firstLetter && ch != '0') {
                secondNonZero = ch;
                break;
            }
        }

        if (firstNonNine == '#') {
            maxNum = new StringBuilder(stringNum);
        }
        else {
            for (char ch : stringNum.toCharArray()) {
                if (ch == firstNonNine) {
                    maxNum.append('9');
                }
                else maxNum.append(ch);
            }
        }

        if (secondNonZero == '#') {
            for (char ch : stringNum.toCharArray()) {
                if (ch != '0') {
                    minNum.append('1');
                }
            }
        }
        else {
            for (char ch : stringNum.toCharArray()) {
                if (ch == secondNonZero) {
                    minNum.append('0');
                }
                else minNum.append(ch);
            }
        }

        int maxNumInt = Integer.parseInt(maxNum.toString());
        int minNumInt = Integer.parseInt(minNum.toString());

        return maxNumInt - minNumInt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int num = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.findInt(num));
        }

        sc.close();
    }
}
