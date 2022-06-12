import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String ans = "";
        int n = sentence.length();

        for (int i = 0; i < n; ++i) {
            String currentWord = "";
            while (i < n && sentence.charAt(i) != ' ') {
                currentWord += sentence.charAt(i);
                ++i;
            }
            ans = currentWord + ' ' + ans;
        }

        System.out.println(ans);

        sc.close();
    }
}
