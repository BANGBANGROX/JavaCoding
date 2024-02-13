import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y) return 0;

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int answer = 0;
        int upperLimit = 11000;
        int lowerLimit = -1000;

        q.add(y);
        visited.add(y);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                assert q.peek() != null;
                int num = q.poll();
                // System.out.println(num);
                if (num + 1 == x || num - 1 == x || num * 5 == x || num * 11 == x) {
                    return answer + 1;
                }
                if (!visited.contains(num + 1) && num + 1 <= upperLimit) {
                    visited.add(num + 1);
                    q.add(num + 1);
                }
                if (!visited.contains(num - 1) && num - 1 >= lowerLimit) {
                    visited.add(num - 1);
                    q.add(num - 1);
                }
                if (!visited.contains(num * 5) && num * 5 <= upperLimit) {
                    visited.add(num * 5);
                    q.add(num * 5);
                }
                if (!visited.contains(num * 11) && num * 11 <= upperLimit) {
                    visited.add(num * 11);
                    q.add(num * 11);
                }
            }
            ++answer;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumOperationsToMakeEqual(x, y));
        }

        sc.close();
    }
}
