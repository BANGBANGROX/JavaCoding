import java.util.Scanner;

public class CodingRound1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
        int ans = 0;

        while(true) {
            int num = Integer.MAX_VALUE, index = -1;
            for (int i = 0; i < n; ++i) {
                if (a[i] < num && !vis[i]) {
                    index = i;
                    num = a[i];
                }
            }
            if (index == -1) break;
            ans += num;
            vis[index] = true;
            for (int i = index - 1; i > -1; --i) {
                if (!vis[i])  {
                    vis[i] = true;
                    break;
                }
            }
            for (int i = index + 1; i < n; ++i) {
                if (!vis[i]) {
                    vis[i] = true;
                    break;
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
