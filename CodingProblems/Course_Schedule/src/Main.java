import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    private  List<List<Integer>> graph;
    private boolean[] recStack;
    private boolean[] vis;

    private boolean isCycle(int node) {
        vis[node] = true;
        recStack[node] = true;

        for (int child : graph.get(node)) {
            if (!vis[child]) {
                if (isCycle(child)) return true;
            }
            else if (recStack[child]) return true;
        }

        recStack[node] = false;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>(numCourses);
        vis = new boolean[numCourses];
        recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

         for (int[] edge : prerequisites) {
             int u = edge[0];
             int v = edge[1];
             graph.get(u).add(v);
         }

         for (int i = 0; i < numCourses; ++i) {
             if (!vis[i]) {
                 if (isCycle(i)) return false;
             }
         }

         return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
