import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int finalSize = 0;

        for (int i = 0; i < nums.size(); ++i) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); ++j) {
                int tot = i + j;
                if (lists.size() < tot + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(tot).add(row.get(j));
                ++finalSize;
            }
        }

        int[] answer = new int[finalSize];
        int idx = 0;

        for (ArrayList<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; --i) {
                answer[idx] = list.get(i);
                ++idx;
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
            int rows = sc.nextInt();
            List<List<Integer>> nums = new ArrayList<>();
            for (int i = 0; i < rows; ++i) {
                int n = sc.nextInt();
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; ++j) {
                    int num = sc.nextInt();
                    row.add(num);
                }
                nums.add(new ArrayList<>(row));
            }

            Solution solution = new Solution();
            int[] answer = solution.findDiagonalOrder(nums);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
