import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int m = elements.length;
        int n = groups.length;
        int maxValue = Arrays.stream(groups).max().getAsInt();
        int[] indexOfValue = new int[maxValue + 1];
        int[] answer = new int[n];
        Set<Integer> visited = new HashSet<>();

        Arrays.fill(indexOfValue, -1);

        for (int i = 0; i < m; ++i) {
            if (!visited.contains(elements[i])) {
                for (int j = elements[i]; j <= maxValue; j += elements[i]) {
                    if (indexOfValue[j] == -1) {
                        indexOfValue[j] = i;
                    }
                }
                visited.add(elements[i]);
            }
        }

        for (int i = 0; i < n; ++i) {
            answer[i] = indexOfValue[groups[i]];
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int[] groups = new int[m];
           for (int i = 0; i < m; ++i) {
               groups[i] = scanner.nextInt();
           }
           int n = scanner.nextInt();
           int[] elements = new int[n];
           for (int i = 0; i < n; ++i) {
               elements[i] = scanner.nextInt();
           }

           for (int x : new Solution().assignElements(groups, elements)) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
