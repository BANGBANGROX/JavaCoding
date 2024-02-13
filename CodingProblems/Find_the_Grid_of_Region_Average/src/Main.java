import java.util.Scanner;

class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        int[][] answer = new int[m][n];
        final int GRID_SIZE = 3;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int gridCount = 0;
                int gridAverageSum = 0;
                for (int fr = Math.max(i - GRID_SIZE + 1, 0); fr <= i; ++fr) {
                    for (int fc = Math.max(j - GRID_SIZE + 1, 0); fc <= j; ++fc) {
                        int lr = fr + GRID_SIZE - 1;
                        int lc = fc + GRID_SIZE - 1;
                        if (lr >= m || lc >= n) {
                            continue;
                        }
                        int currentGridSum = 0;
                        boolean isSubGridRegion = true;
                        for (int x = fr; x <= lr; ++x) {
                            for (int y = fc; y <= lc; ++y) {
                                currentGridSum += image[x][y];
                                if (x > fr  && Math.abs(image[x - 1][y] - image[x][y]) > threshold) {
                                    isSubGridRegion = false;
                                    break;

                                }
                                if (y > fc && Math.abs(image[x][y - 1] - image[x][y]) > threshold) {

                                    isSubGridRegion = false;
                                    break;

                                }
                            }
                            if (!isSubGridRegion) {
                                break;
                            }
                        }
                        if (isSubGridRegion) {
                            gridAverageSum += currentGridSum / 9;
                            ++gridCount;
                        }
                    }
                }
                if (gridCount > 0) {
                    answer[i][j] = gridAverageSum / gridCount;
                } else {
                    answer[i][j] = image[i][j];
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
            int[][] image = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    image[i][j] = sc.nextInt();
                }
            }
            int threshold = sc.nextInt();

            Solution solution = new Solution();
            int[][] answer = solution.resultGrid(image, threshold);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
