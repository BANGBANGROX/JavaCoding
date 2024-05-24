import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private record Pair(double first, int second) {
        public double getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<Pair> wageToQualityRatios = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        double maxRatio = 0;
        int qualitySum = 0;
        int n = quality.length;

        for (int i = 0; i < n; ++i) {
            wageToQualityRatios.add(new Pair(wage[i] * 1.0 / quality[i], i));
        }

        wageToQualityRatios.sort(Comparator.comparingDouble(Pair::getFirst));

        for (int i = 0; i < k; ++i) {
            int idx = wageToQualityRatios.get(i).getSecond();
            qualitySum += quality[idx];
            maxRatio = Math.max(maxRatio, wageToQualityRatios.get(i).getFirst());
            maxHeap.add(quality[idx]);
        }

        double answer = maxRatio * qualitySum;

        for (int i = k; i < n; ++i) {
            assert maxHeap.size() > 0;
            qualitySum -= maxHeap.poll();
            int idx = wageToQualityRatios.get(i).getSecond();
            qualitySum += quality[idx];
            maxRatio = Math.max(maxRatio, wageToQualityRatios.get(i).getFirst());
            maxHeap.add(quality[idx]);
            answer = Math.min(answer, maxRatio * qualitySum);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] quality = new int[n];
            for (int i = 0; i < n; ++i) {
                quality[i] = sc.nextInt();
            }
            int[] wage = new int[n];
            for (int i = 0; i < n; ++i) {
                wage[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().minCostToHireWorkers(quality, wage, k));
        }

        sc.close();
    }
}
