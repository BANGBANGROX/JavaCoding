import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(a -> a.split("/").length));
        Set<String> visited = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for (String currentPath : folder) {
            boolean canAdd = true;
            String[] currentPathArray = currentPath.split("/");
            StringBuilder builder = new StringBuilder();
            for (String s : currentPathArray) {
                if (!s.isEmpty()) {
                    builder.append("/").append(s);
                    if (visited.contains(builder.toString())) {
                        canAdd = false;
                        break;
                    }
                }
            }
            if (canAdd) {
                answer.add(currentPath);
                visited.add(currentPath);
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           String[] folder = new String[n];
           for (int i = 0; i < n; ++i) {
               folder[i] = scanner.next();
           }

           System.out.println(new Solution().removeSubfolders(folder));
       }
       
       scanner.close();
   }
}
