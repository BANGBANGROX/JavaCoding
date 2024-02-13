import java.util.*;

class FoodRatings {
    private static class FoodDetails {
        String foodName;
        String foodCuisine;
        int foodRating;

        FoodDetails(String foodName, String foodCuisine, int foodRating) {
            this.foodName = foodName;
            this.foodCuisine = foodCuisine;
            this.foodRating = foodRating;
        }
    }

    private final HashMap<Integer, TreeSet<ArrayList<Integer>>> cuisineFoodInfo;
    private final HashMap<String, Integer> foodIndex;
    private final HashMap<String, Integer> cuisinesId;
    private final HashMap<String, Integer> foodCuisine;
    private final HashMap<Integer, Integer> foodRating;
    String[] foods;
    FoodDetails[] foodDetails;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
          cuisineFoodInfo = new HashMap<>();
          foodIndex = new HashMap<>();
          foodCuisine = new HashMap<>();
          cuisinesId = new HashMap<>();
          foodRating = new HashMap<>();
          this.foods = foods;
          int currentCuisineId = 1;
          int n = cuisines.length;
          foodDetails = new FoodDetails[n];

          for (int i = 0; i < n; ++i) {
              foodDetails[i] = new FoodDetails(foods[i], cuisines[i], ratings[i]);
          }

          Arrays.sort(foodDetails, Comparator.comparing(a -> a.foodName));
          Arrays.sort(this.foods);

          for (int i = 0; i < n; ++i) {
              String cuisine = foodDetails[i].foodCuisine;
              String food = foodDetails[i].foodName;
              int rating = foodDetails[i].foodRating;
              int cid;
              if (cuisinesId.containsKey(cuisine)) {
                  cid = cuisinesId.get(cuisine);
              }
              else {
                  cuisinesId.put(cuisine, currentCuisineId);
                  cid = currentCuisineId;
                  ++currentCuisineId;
              }
              if (!cuisineFoodInfo.containsKey(cid)) {
                  cuisineFoodInfo.put(cid, new TreeSet<>((a, b) ->
                          !Objects.equals(a.get(0), b.get(0)) ? b.get(0) - a.get(0) :
                                  a.get(1) - b.get(1)));
              }
              foodIndex.put(food, i);
              foodCuisine.put(food, cid);
              foodRating.put(i, rating);
              cuisineFoodInfo.get(cid).add(new ArrayList<>(Arrays.asList(rating, i)));
          }
    }

    public void changeRating(String food, int newRating) {
        int cid = foodCuisine.get(food);
        int idx = foodIndex.get(food);
        int rating = foodRating.get(idx);

        cuisineFoodInfo.get(cid).remove(new ArrayList<>(Arrays.asList(rating, idx)));
        foodRating.put(idx, newRating);
        cuisineFoodInfo.get(cid).add(new ArrayList<>(Arrays.asList(newRating, idx)));
    }

    public String highestRated(String cuisine) {
        return foods[Objects.requireNonNull(cuisineFoodInfo.
                get(cuisinesId.get(cuisine)).first()).get(1)];
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

public class Main {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"Sushi", "Pav bhaji", "Chole Bhature"},
                new String[]{"Japanese", "Indian", "Indian"}, new int[]{5, 8, 9});

        System.out.println(foodRatings.highestRated("Japanese"));
        System.out.println(foodRatings.highestRated("Indian"));

        foodRatings.changeRating("Pav bhaji", 10);

        System.out.println(foodRatings.highestRated("Indian"));
    }
}
