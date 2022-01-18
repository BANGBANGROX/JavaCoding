import java.util.Scanner;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        for (int i = 0; i < len; ++i) {
            if (n == 0) return true;
            if (flowerbed[i] == 1) continue;
            if (i == 0 && i < len - 1 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                --n;
            }
            else if (i > 0 && i < len - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                --n;
            }
            else if (i == len - 1 && i > 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                --n;
            }
            else if (i == len - 1 && i == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                --n;
            }
        }

        return n == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int len = sc.nextInt();
            int[] flowerbed = new int[len];
            for (int i = 0; i < len; ++i) {
                flowerbed[i] = sc.nextInt();
            }
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.canPlaceFlowers(flowerbed, n));
        }

        sc.close();
    }
}
