abstract class Super {
    public Super() {
        System.out.println("Hello from Super");
    }

    public void meth1() {
        System.out.println("Hello from meth1 of Super class");
    }

    abstract public void meth2();
}

class Sub extends Super {
    public Sub() {
        System.out.println("Hello from Sub");
    }

    public void meth2() {
        System.out.println("Hello from meth2 of Sub class");
    }
}

public class Practice1 {
    public static void main (String[] args) {
        Super s1 = new Sub();

        s1.meth1();
        s1.meth2();
    }
}
