import java.util.*;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        HashSet<Integer> finalScore = new HashSet<>();
        int answer = 0;

        Arrays.sort(rewardValues);
        finalScore.add(0);

        for (int reward : rewardValues) {
            HashSet<Integer> nextScore = new HashSet<>();
            for (int score : finalScore) {
                if (reward > score) {
                    nextScore.add(score + reward);
                }
            }
            finalScore.addAll(nextScore);
        }

        for (int score : finalScore) {
            answer = Math.max(answer, score);
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
          int[] rewardValues = new int[n];
          for (int i = 0; i < n; ++i) {
              rewardValues[i] = sc.nextInt();
          }

          System.out.println(new Solution().maxTotalReward(rewardValues));
      }
      
      sc.close(); 
  }
}
