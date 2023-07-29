import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;
        List<List<Integer>> layerMatrix = new ArrayList<>();

        for (int i = 0; i < layers; ++i) {
            List<Integer> currentLayer = new ArrayList<>();
            for (int j = i; j < (n - i - 1); ++j) {
                currentLayer.add(matrix.get(i).get(j));
            }
            for (int j = i; j < (m - i - 1); ++j) {
                currentLayer.add(matrix.get(j).get(n - i - 1));
            }
            for (int j = n - i - 1; j > i; --j) {
                currentLayer.add(matrix.get(m - i - 1).get(j));
            }
            for (int j = m - i - 1; j > i; --j) {
                currentLayer.add(matrix.get(j).get(i));
            }
            layerMatrix.add(new ArrayList<>(currentLayer));
        }

        for (int i = 0; i < layers; ++i) {
            int len = layerMatrix.get(i).size();
            int idx = r % len;
            for (int j = i; j < (n - i - 1); ++j) {
                matrix.get(i).set(j, layerMatrix.get(i).get(idx));
                idx = (idx + 1) % len;
            }
            for (int j = i; j < (m - i - 1); ++j) {
                matrix.get(j).set(n - i - 1, layerMatrix.get(i).get(idx));
                idx = (idx + 1) % len;
            }
            for (int j = n - i - 1; j > i; --j) {
                matrix.get(m - i - 1).set(j, layerMatrix.get(i).get(idx));
                idx = (idx + 1) % len;
            }
            for (int j = m - i - 1; j > i; --j) {
                matrix.get(j).set(i, layerMatrix.get(i).get(idx));
                idx = (idx + 1) % len;
            }
        }

        for (List<Integer> row : matrix) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
