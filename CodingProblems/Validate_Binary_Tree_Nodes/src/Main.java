import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];

        Arrays.fill(parent, -1);

        for (int i = 0; i < n; ++i) {
            int left = leftChild[i];
            int right = rightChild[i];
            if (left != -1) {
                if (parent[left] == -1) {
                    parent[left] = i;
                } else if (parent[left] != i) return false;
            }
            if (right != -1) {
                if (parent[right] == -1) {
                    parent[right] = i;
                } else if (parent[right] != i) return false;
            }
        }

        int rootNode = -1;

        for (int i = 0; i < n; ++i) {
            if (parent[i] == -1) {
                if (rootNode == -1) {
                    rootNode = i;
                } else return false;
            }
        }

        if (rootNode == -1) return false;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(rootNode);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (visited[node]) return false;
            visited[node] = true;
            if (leftChild[node] != -1) q.add(leftChild[node]);
            if (rightChild[node] != -1) q.add(rightChild[node]);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                return false;
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
            int n = sc.nextInt();
            int[] leftChild = new int[n];
            for (int i = 0; i < n; ++i) {
                leftChild[i] = sc.nextInt();
            }
            int[] rightChild = new int[n];
            for (int i = 0; i < n; ++i) {
                rightChild[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.validateBinaryTreeNodes(n, leftChild, rightChild));
        }

        sc.close();
    }
}
