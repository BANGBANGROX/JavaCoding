import java.util.Scanner;

public class Main {
    public static String sortShelf(int n, char[] toys) {
        int xCount = 0;
        int yCount = 0;
        int zCount = 0;
        StringBuilder ans = new StringBuilder();

        for (char ch : toys) {
            if (ch == 'X') ++xCount;
            if (ch == 'Y') ++yCount;
            if (ch == 'Z') ++zCount;
        }

        while (xCount > 0) {
            ans.append('X');
            --xCount;
        }

        while (yCount > 0) {
            ans.append('Y');
            --yCount;
        }

        while (zCount > 0) {
            ans.append('Z');
            --zCount;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            char[] toys = new char[n];
            for (int i = 0; i < n; ++i) {
                toys[i] = sc.next().charAt(0);
            }

            System.out.println(sortShelf(n, toys));
        }

        sc.close();
    }
}
