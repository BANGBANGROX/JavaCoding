import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private HashMap<String, Integer> dp;
    private String key;

    private int clockwiseRotationSteps(char[] ringArray, char keyChar) {
        if (ringArray[0] == keyChar) return 1;

        int length = ringArray.length;
        char firstChar = ringArray[0];
        ringArray[0] = ringArray[length - 1];

        for (int i = 1; i < length; ++i) {
            char temp = ringArray[i];
            ringArray[i] = firstChar;
            firstChar = temp;
        }

        return clockwiseRotationSteps(ringArray, keyChar) + 1;
    }

    private int antiClockwiseRotationSteps(char[] ringArray, char keyChar) {
        if (ringArray[0] == keyChar) return 1;

        int length = ringArray.length;
        char lastChar = ringArray[length - 1];
        ringArray[length - 1] = ringArray[0];

        for (int i = length - 2; i >= 0; --i) {
            char temp = ringArray[i];
            ringArray[i] = lastChar;
            lastChar = temp;
        }

        return antiClockwiseRotationSteps(ringArray, keyChar) + 1;
    }

    private int finalRotateStepsHandler(String ring, int idx) {
        if (idx >= key.length()) return 0;

        String mapKey = ring + "|" + idx;

        if (dp.containsKey(mapKey)) return dp.get(mapKey);

        char[] clockwiseArray = ring.toCharArray();
        char[] antiClockwiseArray = ring.toCharArray();
        int result = Math.min(clockwiseRotationSteps(clockwiseArray, key.charAt(idx)) + finalRotateStepsHandler(new String(clockwiseArray), idx + 1), antiClockwiseRotationSteps(antiClockwiseArray, key.charAt(idx)) + finalRotateStepsHandler(new String(antiClockwiseArray), idx + 1));

        dp.put(mapKey, result);

        return result;
    }

    public int findRotateSteps(String ring, String key) {
        dp = new HashMap<>();
        this.key = key;

        return finalRotateStepsHandler(ring, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String ring = sc.next();
            String key = sc.next();

            System.out.println(new Solution().findRotateSteps(ring, key));
        }

        sc.close();
    }
}
