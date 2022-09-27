import java.util.Scanner;

class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) return parent[x] = find(parent[x]);

        return x;
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];

        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }

        for (String eq: equations) {
            if (eq.charAt(1) == '=') parent[find(eq.charAt(0) - 'a')] = find(eq.charAt(3) - 'a');
        }

        for (String eq: equations) {
            if (eq.charAt(1) == '!' && find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a'))
                return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] equations = new String[n];
            for (int i = 0; i < n; ++i) {
                equations[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.equationsPossible(equations));
        }

        sc.close();
    }
}
