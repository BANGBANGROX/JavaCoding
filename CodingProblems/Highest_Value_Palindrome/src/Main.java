import java.io.*;

class Result {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
        // Write your code here
        char[] chars = s.toCharArray();
        int mid = n / 2;
        boolean[] isPalindrome = new boolean[mid];

        for (int i = 0; i < mid; ++i) {
            isPalindrome[i] = (chars[i] == chars[n - i - 1]);
            if (!isPalindrome[i]) {
                if (k > 0) --k;
                else return "-1";
            }
            chars[i] = (char)Math.max(chars[i], chars[n - i - 1]);
            chars[n - i - 1] = chars[i];
        }

        for (int i = 0; i < mid && k > 0; ++i) {
            if (chars[i] != '9' && (!isPalindrome[i] || k > 1)) {
                chars[i] = chars[n - i - 1] = '9';
                k -= (isPalindrome[i] ? 2 : 1);
            }
        }

        if ((n & 1) > 0 && k > 0) chars[mid] = '9';

        return new String(chars);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
