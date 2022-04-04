import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        if (arr[start] == 0) return true;

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            int positionA = node + arr[node];
            int positionB = node - arr[node];
            if (positionA < n && !visited[positionA]) {
                if (arr[positionA] == 0) return true;
                q.add(positionA);
                visited[positionA] = true;
            }
            if (positionB >= 0 && !visited[positionB]) {
                if (arr[positionB] == 0) return true;
                q.add(positionB);
                visited[positionB] = true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }
            int start = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.canReach(arr, start));
        }

        sc.close();
    }
}
