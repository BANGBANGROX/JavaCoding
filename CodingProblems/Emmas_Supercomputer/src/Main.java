import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

class Result {

    private static boolean isValid(int x, int y, int m, int n, List<char[]> grid, char ch) {
        return x >= 0 && x < m && y >= 0 && y < n && grid.get(x)[y] == ch;
    }

    /*
     * Complete the 'twoPluses' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static int twoPluses(List<String> grid) {
        // Write your code here
        List<char[]> copyOfGrid = new ArrayList<>();
        int m = grid.size();
        int n = grid.get(0).length();
        int answer = 0;

        for (String s : grid) {
            copyOfGrid.add(s.toCharArray());
        }

        for (int a = 0; a < m; ++a) {
            for (int b = 0; b < n; ++b) {
                int r1 = 0;
                while (isValid(a + r1, b, m, n, copyOfGrid, 'G') &&
                        isValid(a - r1, b, m, n, copyOfGrid, 'G') &&
                        isValid(a, b + r1, m, n, copyOfGrid, 'G') &&
                        isValid(a, b - r1, m, n, copyOfGrid, 'G')) {
                    copyOfGrid.get(a + r1)[b] = copyOfGrid.get(a - r1)[b] =
                            copyOfGrid.get(a)[b + r1] = copyOfGrid.get(a)[b - r1] = 'g';
                    for (int c = 0; c < m; ++c) {
                        for (int d = 0; d < n; ++d) {
                            int r2 = 0;
                            while (isValid(c + r2, d, m, n, copyOfGrid, 'G') &&
                                    isValid(c - r2, d, m, n, copyOfGrid, 'G') &&
                                    isValid(c, d + r2, m, n, copyOfGrid, 'G') &&
                                    isValid(c, d - r2, m, n, copyOfGrid, 'G')) {
                                answer = Math.max(answer, (4 * r1 + 1) * (4 * r2 + 1));
                                ++r2;
                            }
                        }
                    }
                    ++r1;
                }
                r1 = 0;
                while (isValid(a + r1, b, m, n, copyOfGrid, 'g') &&
                        isValid(a - r1, b, m, n, copyOfGrid, 'g') &&
                        isValid(a, b + r1, m, n, copyOfGrid, 'g') &&
                        isValid(a, b - r1, m, n, copyOfGrid, 'g')) {
                    copyOfGrid.get(a + r1)[b] = copyOfGrid.get(a - r1)[b] =
                            copyOfGrid.get(a)[b + r1] = copyOfGrid.get(a)[b - r1] = 'G';
                    ++r1;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result.twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
