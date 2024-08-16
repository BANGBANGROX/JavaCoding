import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);
        int answer = 0;
        int n = arrays.size();

        for (int i = 1; i < n; ++i) {
            int size = arrays.get(i).size();
            answer = Math.max(answer, Math.abs(arrays.get(i).get(0) - maxValue));
            answer = Math.max(answer, Math.abs(arrays.get(i).get(size - 1) - maxValue));
            answer = Math.max(answer, Math.abs(arrays.get(i).get(0) - minValue));
            answer = Math.max(answer, Math.abs(arrays.get(i).get(size - 1) - minValue));
            minValue = Math.min(minValue, arrays.get(i).get(0));
            maxValue = Math.max(maxValue, arrays.get(i).get(size - 1));
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            List<List<Integer>> arrays = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int size = scanner.nextInt();
                arrays.add(new ArrayList<>());
                for (int j = 0; j < size; ++j) {
                    arrays.get(i).add(scanner.nextInt());
                }
            }

            System.out.println(new Solution().maxDistance(arrays));
        }

        scanner.close();
    }
}
