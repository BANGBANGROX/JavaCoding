import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
          List<List<Integer>> ans = new ArrayList<>();

          for (int i = 0; i < numRows; ++i) {
              List<Integer> auxiliaryList = new ArrayList<>();
              for (int j = 0; j <= i; ++j) {
                  if (i == 0 || j == 0 || j == i) {
                      auxiliaryList.add(1);
                  }
                  else {
                      auxiliaryList.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                  }
              }
              ans.add(auxiliaryList);
          }

          return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int numRows = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.generate(numRows));
        }

        sc.close();
    }
}
