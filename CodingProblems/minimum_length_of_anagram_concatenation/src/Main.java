import java.util.*;

class Solution {
    private String s;

    private ArrayList<Integer> getFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 1; i * i <= num; ++i) {
            if (num % i == 0) {
                factors.add(i);
                if (num / i != i) {
                    factors.add(num / i);
                }
            }
        }

        Collections.sort(factors);

        return factors;
    }

    private boolean checkLength(int len) {
        HashSet<String> visited = new HashSet<>();
        int left = 0;
        int right = len - 1;
        StringBuilder currentString = new StringBuilder();

        for (int i = left; i <= right; ++i) {
            currentString.append(s.charAt(i));
        }

        while (right < s.length()) {
            char[] currentStringArray = currentString.toString().toCharArray();
            Arrays.sort(currentStringArray);
            currentString = new StringBuilder(new String(currentStringArray));
            if (!visited.isEmpty() && !visited.contains(currentString.toString())) {
                return false;
            }
            visited.add(currentString.toString());
            left += len;
            right += len;
            if (right < s.length()) {
                currentString = new StringBuilder();
                for (int i = left; i <= right; ++i) {
                    currentString.append(s.charAt(i));
                }
            }
        }

        return true;
    }

    public int minAnagramLength(String s) {
        int length = s.length();
        ArrayList<Integer> factors = getFactors(length);

        for (int factor : factors) {
            if (checkLength(factor)) return factor;
        }

        return -1;
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
