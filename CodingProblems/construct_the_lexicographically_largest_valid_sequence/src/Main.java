import java.util.Scanner;

class Solution {
    private int[] answer;
    private boolean[] visited;
    private int size;
    private int n;

    private boolean build(int idx) {
        if (idx == size) return true;

        if (answer[idx] != 0) return build(idx + 1);

        for (int i = n; i > 0; --i) {
            if (visited[i]) continue;
            answer[idx] = i;
            visited[i] = true;
            if (i == 1) {
                if (build(idx + 1)) return true;
            } else if (idx + i < size && answer[idx + i] == 0) {
                answer[idx + i] = i;
                if (build(idx + 1)) return true;
                answer[idx + i] = 0;
            }
            answer[idx] = 0;
            visited[i] = false;
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        size = 2 * n - 1;
        answer = new int[size];
        visited = new boolean[n + 1];

        build(0);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           for (int x : new Solution().constructDistancedSequence(scanner.nextInt())) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
