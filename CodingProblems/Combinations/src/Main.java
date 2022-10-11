import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

class Solution {
    private List<List<Integer>> ans;
    private LinkedList<Integer> current;

    private void generate(int n, int k) {
        if (k == 0) {
            ans.add(new LinkedList<>(current));
            return;
        }

        if (n < k) return;

        generate(n - 1, k);

        current.add(n);
        generate(n - 1, k - 1);

        current.pollLast();
    }

    public List<List<Integer>> combine(int n, int k) {
         ans = new LinkedList<>();
         current = new LinkedList<>();

         generate(n, k);

         return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.combine(n, k));
        }

        sc.close();
    }
}
