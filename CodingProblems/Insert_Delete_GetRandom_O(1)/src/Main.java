import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class RandomizedSet {
    private final ArrayList<Integer> nums;
    private final Map<Integer, Integer> index;

    public RandomizedSet() {
        nums = new ArrayList<>();
        index = new HashMap<>();
    }

    public boolean insert(int val) {
        if (index.containsKey(val)) return false;

        index.put(val, nums.size());
        nums.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;

        int ind = index.get(val);
        int value = nums.get(nums.size() - 1);

        if (ind != nums.size() - 1) {
            nums.set(ind, value);
            index.put(value, ind);
        }

        nums.remove(nums.size() - 1);
        index.remove(val);

        return true;
    }

    public int getRandom() {
        int ind = (int)(Math.random() * nums.size());

        return nums.get(ind);
    }
}

public class Main {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }
}
