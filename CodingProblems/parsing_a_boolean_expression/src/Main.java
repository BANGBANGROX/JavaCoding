import java.util.Scanner;

class Solution {
    private int idx;
    private String expression;

    private boolean parseBoolExprHandler() {
        char operation = expression.charAt(idx);

        idx += 2;

        char ch = expression.charAt(idx);
        boolean result;

        if (ch == 't') {
            result = true;
            ++idx;
        } else if (ch == 'f') {
            result = false;
            ++idx;
        } else {
            result = parseBoolExprHandler();
        }

        ch = expression.charAt(idx);

        while (ch != ')') {
            if (ch == ',') {
                ++idx;
            } else {
                boolean current;
                if (ch == 't') {
                    current = true;
                    ++idx;
                } else if (ch == 'f') {
                    current = false;
                    ++idx;
                } else {
                    current = parseBoolExprHandler();
                }
                if (operation == '&') {
                    result &= current;
                } else if (operation == '|') {
                    result |= current;
                }
            }
            ch = expression.charAt(idx);
        }

        ++idx;

        return (operation == '!') != result;
    }

    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) {
            return expression.charAt(0) == 't';
        }

        idx = 0;
        this.expression = expression;

        return parseBoolExprHandler();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String expression = sc.next();

            System.out.println(new Solution().parseBoolExpr(expression));
        }

        sc.close();
    }
}
