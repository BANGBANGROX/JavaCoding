import java.util.*;

class Cylinder {
    private double radius, height;

    public Cylinder (double r, double h) {
        setRadius(r);
        setHeight(h);
    }

    public void setRadius (double r) {
        radius = r > 0 ? r : 0;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight (double h) {
        height = h > 0 ? h : 0;
    }

    public double calcCSA() {
        double CSA = 2 * Math.PI * radius * height;

        return CSA;
    }

    public double calcTSA() {
        double TSA = 2 * Math.PI * radius * (radius + height);

        return TSA;
    }

    public double calcVolume() {
        double vol = Math.PI * radius * radius * height;

        return vol;
    }
}

public class Challenge4Question1 {

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the radius and the height of the cylinder: ");

        double r = sc.nextDouble();
        double h = sc.nextDouble();

        Cylinder cylin = new Cylinder(r, h);

        double radius = cylin.getRadius();
        double height = cylin.getHeight();
        double CSA = cylin.calcCSA();
        double TSA = cylin.calcTSA();
        double vol = cylin.calcVolume();

        System.out.printf("Radius = %f\nHeight = %f\nCSA = %.2f sq units\nTSA = %.2f sq units\nVolume = %.2f " +
                "cubic units\n", radius, height, CSA, TSA, vol);

        sc.close();
    }
}
