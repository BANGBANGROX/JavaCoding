import java.util.Scanner;

class Solution {
    private int answer;
    private int[][] requests;
    private int[] inDegree;
    private int n;

    private void maximumRequestsHandler(int index, int currentCount) {
        if (index == n) {
            for (int cnt : inDegree) {
                if (cnt > 0) return;
            }

            answer = Math.max(answer, currentCount);
            return;
        }

        --inDegree[requests[index][0]];
        ++inDegree[requests[index][1]];

        maximumRequestsHandler(index + 1, currentCount + 1);

        ++inDegree[requests[index][0]];
        --inDegree[requests[index][1]];

        maximumRequestsHandler(index + 1, currentCount);
    }

    public int maximumRequests(int numberOfBuildings, int[][] requests) {
        answer = 0;
        this.requests = requests;
        inDegree = new int[numberOfBuildings];
        n = requests.length;

        maximumRequestsHandler(0, 0);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int numberOfBuildings = sc.nextInt();
            int n = sc.nextInt();
            int[][] requests = new int[n][2];
            for (int i = 0; i < n; ++i) {
                requests[i][0] = sc.nextInt();
                requests[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maximumRequests(numberOfBuildings, requests));
        }

        sc.close();
    }
}
