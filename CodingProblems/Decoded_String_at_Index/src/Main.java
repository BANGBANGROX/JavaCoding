import java.util.Scanner;

class Solution {
    public String decodeAtIndex(String s, int k) {
        double len = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                len *= (ch - '0');
            } else {
                len += 1;
            }
        }

        s = new StringBuilder(s).reverse().toString();

        for (char ch : s.toCharArray()) {
            k %= len;
            if (k == 0 && Character.isAlphabetic(ch)) return "" + ch;
            if (Character.isDigit(ch)) len /= (ch - '0');
            else --len;
        }

        return "";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.decodeAtIndex(s, k));
        }

        sc.close();
    }
}
