import java.util.*;

class Solution {
    private int m;
    private int n;
    private int primeNumber;
    private int[][] mat;
    private int[] count;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private boolean checkPrimeNumber(int num) {
        if (num <= 1) return false;

        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int x, int y, int dir, int currentNumber) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;

        currentNumber = currentNumber * 10 + mat[x][y];

        if (currentNumber > 10 && checkPrimeNumber(currentNumber)) {
            ++count[currentNumber];
            if (count[currentNumber] > count[primeNumber] || count[currentNumber] == count[primeNumber] && currentNumber > primeNumber) {
                primeNumber = currentNumber;
            }
        }

        dfs(x + directions[dir][0], y + directions[dir][1], dir, currentNumber);
    }

    public int mostFrequentPrime(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        this.mat = mat;
        int maxCount = 0;
        int answer = -1;
        primeNumber = 0;
        int MAX_N = (int) 1e6 + 5;
        count = new int[MAX_N];

//        buildSieve();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int dir = 0; dir < 8; ++dir) {
                    dfs(i, j, dir, 0);
                    if (primeNumber == 0) continue;
                    if (count[primeNumber] > maxCount || count[primeNumber] == maxCount && primeNumber > answer) {
                        answer = primeNumber;
                        maxCount = count[primeNumber];
                    }
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] mat = new int[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.mostFrequentPrime(mat));
        }

        sc.close();
    }
}
