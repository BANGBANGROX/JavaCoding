import java.util.Scanner;

class Solution {
    public int hIndex(int[] citations) {
       int n = citations.length;
       int l = 0;
       int r = n - 1;

       while (l <= r) {
           int mid = (l + ((r - l) >> 1));
           if (citations[mid] == (n - mid)) return citations[mid];
           else if (citations[mid] < (n - mid)) l = mid + 1;
           else r = mid - 1;
       }

       return n - l;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] citations = new int[n];
            for (int i = 0; i < n; ++i) {
                citations[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.hIndex(citations));
        }

        sc.close();
    }
}
