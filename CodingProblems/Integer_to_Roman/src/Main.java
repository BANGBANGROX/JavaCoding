import java.util.Scanner;

class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L",
                "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {
                num -= values[i];
                ans.append(chars[i]);
                continue;
            }
            ++i;
        }

        return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int num = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.intToRoman(num));
        }

        sc.close();
    }
}
