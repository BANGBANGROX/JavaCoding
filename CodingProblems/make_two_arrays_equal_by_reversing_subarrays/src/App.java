import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; ++i) {
            if (target[i] != arr[i]) return false;
        }

        return true;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] target = new int[n];
            for (int i = 0; i < n; ++i) {
                target[i] = scanner.nextInt();
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            
            System.out.println(new Solution().canBeEqual(target, arr));
        }

        scanner.close();
    }
}
