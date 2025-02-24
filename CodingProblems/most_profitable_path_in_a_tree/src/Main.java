import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int[] bobVisitTime;
    private int[] amount;
    private List<List<Integer>> tree;
    private int answer;

    private int computeScore(int time, int node) {
        if (bobVisitTime[node] == time) {
            return amount[node] / 2;
        } else if (bobVisitTime[node] > time) {
            return amount[node];
        }

        return 0;
    }

    private boolean bobTraversal(int node, int parent, int time) {
        bobVisitTime[node] = time;

        if (node == 0) return true;

        for (int child : tree.get(node)) {
            if (child != parent) {
                if (bobTraversal(child, node, time + 1)) {
                    return true;
                }
            }
        }

        bobVisitTime[node] = Integer.MAX_VALUE;

        return false;
    }

    private void aliceTraversal(int node, int parent, int time,
                                int currentScore) {
        if (tree.get(node).size() == 1 && tree.get(node).getFirst() == parent) {
            currentScore += computeScore(time, node);
            answer = Math.max(answer, currentScore);
        }

        for (int child : tree.get(node)) {
            if (child != parent) {
                aliceTraversal(child, node, time + 1,
                        currentScore + computeScore(time, node));
            }
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new ArrayList<>();
        bobVisitTime = new int[n];
        this.amount = amount;
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            bobVisitTime[i] = Integer.MAX_VALUE;
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        bobTraversal(bob, -1, 1);
        aliceTraversal(0, -1, 1, 0);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[][] edges = new int[n - 1][2];
           for (int i = 0; i < n; ++i) {
               edges[i][0] = scanner.nextInt();
               edges[i][1] = scanner.nextInt();
           }
           int bob = scanner.nextInt();
           int[] amount = new int[n];
           for (int i = 0; i < n; ++i) {
               amount[i] = scanner.nextInt();
           }

           System.out.print(new Solution().mostProfitablePath(edges, bob, amount));
       }
       
       scanner.close();
   }
}
