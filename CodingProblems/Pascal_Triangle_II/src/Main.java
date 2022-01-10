import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
          List<Integer> currentList = new ArrayList<>();

          for (int i = 0; i <= rowIndex; ++i) {
             List<Integer> newList = new ArrayList<>();
             for (int j = 0; j <= i; ++j) {
                 if (i == 0 || j == 0 || i == j) {
                     newList.add(1);
                 }
                 else {
                     newList.add(currentList.get(j - 1) + currentList.get(j));
                 }
             }
             currentList = newList;
          }

          return currentList;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int rowIndex = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.getRow(rowIndex));
        }

        sc.close();
    }
}
