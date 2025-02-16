import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private final List<Integer> prefixProduct;
    private int lastZeroIndex;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        lastZeroIndex = -1;
    }

    public void add(int num) {
        if (num > 0) {
            if (prefixProduct.isEmpty()) {
                prefixProduct.add(num);
            } else {
                if (prefixProduct.getLast() == 0) {
                    prefixProduct.add(num);
                } else {
                    prefixProduct.add(prefixProduct.getLast() * num);
                }
            }
        } else {
            prefixProduct.add(num);
            lastZeroIndex = prefixProduct.size() - 1;
        }
    }

    public int getProduct(int k) {
        int right = prefixProduct.size() - 1;
        int left = right - k + 1;

        if (lastZeroIndex >= left && lastZeroIndex <= right) return 0;

        if (lastZeroIndex == left - 1) left = 0;

        return left > 0 ? prefixProduct.getLast() / prefixProduct.get(left - 1) :
                prefixProduct.getLast();
    }
}

public class Main {
   public static void main(String[] args) {
       ProductOfNumbers productOfNumbers = new ProductOfNumbers();

       productOfNumbers.add(0);
       productOfNumbers.add(1);
       productOfNumbers.add(2);

       System.out.println(productOfNumbers.getProduct(3));
       System.out.println(productOfNumbers.getProduct(2));
   }
}
