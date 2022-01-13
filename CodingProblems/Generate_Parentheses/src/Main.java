import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    private List<String> ans;
    private int n;

    private void generate(int difference, String current) {
        if (current.length() == 2 * n) {
            if (difference == 0) ans.add(current);
            return;
        }

        if (difference == 0) {
            generate(difference + 1, current + '(');
        }
        else if (difference == n) {
            generate(difference - 1, current + ')');
        }
        else {
            generate(difference + 1, current + '(');
            generate(difference - 1, current + ')');
        }
    }

    public List<String> generateParenthesis(int n) {
        String current = "";
        ans = new ArrayList<>();
        this.n = n;

        generate(0, current);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.generateParenthesis(n));
        }

        sc.close();
    }
}
