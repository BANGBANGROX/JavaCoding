import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        ArrayList<String> powersOf2 = new ArrayList<>();

        for (int i = 1; i <= (int) 1e9; i *= 2) {
            String s = String.valueOf(i);
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            s = new String(sArr);
            powersOf2.add(s);
        }

        String sN = String.valueOf(n);
        char[] nArr = sN.toCharArray();

        Arrays.sort(nArr);
        sN = new String(nArr);

        for (String s: powersOf2) {
            if (sN.equals(s)) return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.reorderedPowerOf2(n));
        }

        sc.close();
    }
}


