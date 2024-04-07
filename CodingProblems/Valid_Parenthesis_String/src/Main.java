import java.util.Scanner;

class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++leftMax;
                ++leftMin;
            }
            else if (ch == ')') {
                --leftMax;
                --leftMin;
            }
            else {
                --leftMax;
                ++leftMin;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) {
                leftMin = 0;
            }
        }

        return leftMin == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            Solution solution = new Solution();

            System.out.println(solution.checkValidString(s));
        }

        sc.close();
    }
}
