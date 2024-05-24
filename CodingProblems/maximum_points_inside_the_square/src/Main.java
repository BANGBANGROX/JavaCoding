import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Solution {
    private boolean isGivenBitSet(int num, int bit) {
        return (num & (1 << bit)) > 0;
    }

    private boolean haveCommonSetBit(int num1, int num2) {
        for (int i = 0; i < 26; ++i) {
            if ((num1 & (1 << i)) > 0 && (num2 & (1 << i)) > 0) return true;
        }

        return false;
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        TreeMap<Integer, Integer> sidesStatus = new TreeMap<>();
        int n = points.length;
        int minUnavailableSide = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            int length = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            sidesStatus.putIfAbsent(length, 0);
            if (isGivenBitSet(sidesStatus.get(length), (s.charAt(i) - 'a'))) {
                minUnavailableSide = Math.min(minUnavailableSide, length);
            }
            else {
                sidesStatus.put(length, sidesStatus.get(length) ^ (1 << (s.charAt(i) - 'a')));
            }
        }

        for (Map.Entry<Integer, Integer> entry : sidesStatus.entrySet()) {
            if (entry.getKey() >= minUnavailableSide || haveCommonSetBit(answer, entry.getValue())) {
                break;
            }
            answer ^= entry.getValue();
        }

        return Integer.bitCount(answer);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
