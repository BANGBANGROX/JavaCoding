
public class Challenge3Question1 {
    static int maxOfNumbers (int ...x) {
    	int maxNum = Integer.MIN_VALUE;
    	
    	for (int a : x) {
    		if (maxNum < a) {
    			maxNum = a;
    		}
    	}
    	
    	return maxNum;
    }
    
    public static void main (String args[]) {
        int maxNum = maxOfNumbers(1, 2, 3, 6, 100, 1000, 9999, -1, -2, -222);
        
        System.out.println(maxNum);
    }
}
