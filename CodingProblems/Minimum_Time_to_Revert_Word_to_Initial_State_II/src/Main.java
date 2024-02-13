import java.util.Scanner;

class Solution {
    private int[] computeZArray(String word) {
        int n = word.length();
        int l = 0;
        int r = 0;
        int[] result = new int[n];

        for (int i = 1; i < n; ++i) {
            if (i > r) {
                l = r = i;
                while (r < n && word.charAt(r - l) == word.charAt(r)) {
                    ++r;
                }
                result[i] = r - l;
                --r;
            }
            else {
                int k = i - l;
                if (result[k] < r - i + 1) {
                    result[i] = result[k];
                }
                else {
                    l = i;
                    while (r < n && word.charAt(r - l) == word.charAt(r)) {
                        ++r;
                    }
                    result[i] = r - l;
                    --r;
                }
            }
        }

        return result;
    }

    public int minimumTimeToInitialState(String word, int k) {
        int[] zArray = computeZArray(word);
        int answer = 1;
        int n = word.length();

        for (; k * answer < n; ++answer) {
            if (zArray[k * answer] >= n - k * answer) {
                return answer;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String word = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumTimeToInitialState(word, k));
        }

        sc.close();
    }
}
