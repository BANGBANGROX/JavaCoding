
public class Challenge3Question3 {
    static double calcDiscount(double ...prices) {
    	double discount = 0, total = 0;
    	
    	for (double cost : prices) {
    		total += cost;
    	}
    	
    	if (total >= 500 && total < 1000) {
    		discount = total * 0.1;
    	}
    	else if (total >= 1000 && total < 2000) {
    		discount = total * 0.15;
    	}
    	else if (total >= 2000) {
    		discount = total * 0.2;
    	}
    	
    	return discount;
    }
    
    public static void main (String args[]) {
       double discount = calcDiscount(100, 250, 400, 500, 150);
       
       System.out.println(discount);
       
    }
}
