import java.util.Scanner;

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int answer = 0;

        for (int i = 0, cnt = 0; i + 1 < n; ++i, cnt *= -1) {
            if (arr[i] > arr[i + 1]) {
                cnt = (cnt > 0 ? cnt + 1 : 1);
            } else if (arr[i] < arr[i + 1]) {
                cnt = (cnt < 0 ? cnt - 1 : -1);
            } else {
                cnt = 0;
            }
            answer = Math.max(answer, Math.abs(cnt));
        }

        return answer + 1;
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

            System.out.println(new Solution().maxTurbulenceSize(arr));
        }
    }
}