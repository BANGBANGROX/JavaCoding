import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
        int row = grid.size();
        int col = grid.get(0).length();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        if (n > 12) {
            n = n % 12 + 12;
        }

        for (int itr = 0; itr < n; ++itr) {
            List<char[]> next = new ArrayList<>();
            for (String s : grid) {
                next.add(s.toCharArray());
            }
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (grid.get(i).charAt(j) == 'P' || grid.get(i).charAt(j) == 'O') {
                        if (next.get(i)[j] != '.') {
                            ++next.get(i)[j];
                        }
                    } else if (grid.get(i).charAt(j) == 'Q') {
                          next.get(i)[j] = '.';
                          for (int[] direction : directions) {
                              int newI = i + direction[0];
                              int newJ = j + direction[1];
                              if (newI >= 0 && newI < row && newJ >= 0 && newJ < col) {
                                  next.get(newI)[newJ] = '.';
                              }
                          }
                    }
                }
            }
            if ((itr & 1) > 0) {
                for (int i = 0; i < row; ++i) {
                    for (int j = 0; j < col; ++j) {
                        if (next.get(i)[j] == '.') {
                            next.get(i)[j] = 'O';
                        }
                    }
                }
            }
            for (int i = 0; i < row; ++i) {
                grid.set(i, new String(next.get(i)));
            }
        }

        for (int i = 0; i < row; ++i) {
            char[] current = grid.get(i).toCharArray();
            for (int j = 0; j < col; ++j) {
                if (current[j] == 'P' || current[j] == 'Q') {
                    current[j] = 'O';
                }
            }
            grid.set(i, new String(current));
        }

        return grid;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
                String.join("\n", result)
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
