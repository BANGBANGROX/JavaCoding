import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> visited = new HashSet<>();

        for (int num : arr) {
            if (visited.contains(num * 2)) return true;
            if ((num & 1) == 0 && visited.contains(num / 2)) return true;
            visited.add(num);
        }

        return false;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }

           System.out.println(new Solution().checkIfExist(arr));
       }
       
       scanner.close();
   }
}
