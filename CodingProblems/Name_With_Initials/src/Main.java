import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String ans = "";
        int n = name.length();

        for (int i = 0; i < n; ++i) {
            String currentName = "";
            while (i < n && name.charAt(i) != ' ') {
                currentName += name.charAt(i);
                ++i;
            }
            if (i == n) ans += currentName;
            else ans = ans + currentName.charAt(0) + '.';
        }

        System.out.println(ans);

        sc.close();
    }
}
