import java.util.Scanner;

class Solution {
    final int mod = (int)1e9 + 7;

    private int decodeOneCharacter(char ch) {
        if (ch == '*') return 9;

        if (ch == '0') return 0;

        return 1;
    }

    private int decodeTwoCharacters(char first, char second) {
        if (first == '*') {
            if (second == '*') return 15;
            if (second >= '0' && second <= '6') return 2;
            return 1;
        }

        if (first == '1') {
            if (second == '*') return 9;
            if (second >= '0' && second <= '9') return 1;
            return 0;
        }

        if (first == '2') {
            if (second == '*') return 6;
            if (second >= '0' && second <= '6') return 1;
            return 0;
        }

        return 0;
    }

    public int numDecodings(String s) {
        int n = s.length();
        long a = 1;
        long b = decodeOneCharacter(s.charAt(0));

        for (int i = 2; i <= n; ++i) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);
            long value1 = (b * decodeOneCharacter(second)) % mod;
            long value2 = (a * decodeTwoCharacters(first, second)) % mod;
            long c = (value1 + value2) % mod;
            a = b;
            b = c;
        }

        return (int)b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.numDecodings(s));
        }

        sc.close();
    }
}
