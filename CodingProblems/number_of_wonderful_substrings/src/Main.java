import java.util.Scanner;

class Solution {
    public long wonderfulSubstrings(String word) {
        long answer = 0;
        int[] prefixXor = new int[(1 << 10)];
        int currentXor = 0;

        prefixXor[0] = 1;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            currentXor ^= (1 << idx);
            answer += prefixXor[currentXor];
            ++prefixXor[currentXor];
            for (int i = 0; i < 10; ++i) {
                answer += prefixXor[currentXor ^ (1 << i)];
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String word = sc.next();

            System.out.println(new Solution().wonderfulSubstrings(word));
        }

        sc.close();
    }
}
