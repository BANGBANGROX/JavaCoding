import java.util.*;

class Cylinder {
	public double radius, height;
	
	public double calcCSA() {
		double CSA = 2 * Math.PI * radius * height;
		
		return CSA;
	}
	
	public double calcTSA() {
		double TSA = 2 * Math.PI * radius * (height + radius);
		
		return TSA;
	}
	
	public double calcVolume() {
       double volume = Math.PI * radius * radius * height;
       
       return volume;
	}
}

public class Challenge2Question1 {
    public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	Cylinder cylin = new Cylinder();
     	
        System.out.println("Enter radius and height of the cylinder: ");
        
        cylin.radius = sc.nextDouble();
        cylin.height = sc.nextDouble();
        
        double CSA = cylin.calcCSA();
        double TSA = cylin.calcTSA();
        double vol = cylin.calcVolume();
        
        System.out.printf("CSA = %.2f sq units\nTSA = %.2f sq units\nVolume = %.2f", CSA, TSA, vol);
        
        sc.close();
    }
}
