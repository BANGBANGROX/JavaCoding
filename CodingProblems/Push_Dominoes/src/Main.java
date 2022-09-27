import java.util.Scanner;

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int right = -1;
        char[] dominoesArr = dominoes.toCharArray();

        for (int i = 0; i < n; ++i) {
            if (dominoesArr[i] == 'L') {
                if (right == -1) {
                    for (int j = i - 1; j >= 0 && dominoesArr[j] == '.'; --j) {
                        dominoesArr[j] = 'L';
                    }
                }
                else {
                    for (int j = right + 1, k = i - 1; j < k; ++j, --k) {
                        dominoesArr[j] = 'R';
                        dominoesArr[k] = 'L';
                    }
                    right = -1;
                }
            }
            else if (dominoesArr[i] == 'R') {
                if (right != -1) {
                    for (int j = right + 1; j < i; ++j) {
                        dominoesArr[j] = 'R';
                    }
                }
                right = i;
            }
        }

        if (right != -1) {
            for (int i = right + 1; i < n; ++i) {
                dominoesArr[i] = 'R';
            }
        }

        return new String(dominoesArr);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String dominoes = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.pushDominoes(dominoes));
        }

        sc.close();
    }
}
