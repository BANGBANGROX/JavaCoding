import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static class Pair {
        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int maximumSwap(int num) {
        char[] stringNum = String.valueOf(num).toCharArray();
        Pair[] indexStringNum = new Pair[stringNum.length];

        for (int i = 0; i < stringNum.length; ++i) {
            indexStringNum[i] = new Pair(stringNum[i], i);
        }

        Arrays.sort(indexStringNum, (a, b) -> a.first != b.first ? b.first - a.first :
                b.second - a.second);

        for (int i = 0; i < stringNum.length; ++i) {
            if (stringNum[i] != indexStringNum[i].first) {
                int pos = -1;
                for (Pair p : indexStringNum) {
                    if (p.first == indexStringNum[i].first && p.second > i) {
                        pos = p.second;
                        break;
                    }
                }
                char ch = stringNum[i];
                stringNum[i] = stringNum[pos];
                stringNum[pos] = ch;
                break;
            }
        }

        return Integer.parseInt(new String(stringNum));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int num = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maximumSwap(num));
        }

        sc.close();
    }
}
