interface Test {
    void meth1();
    void meth2();
}

class Test1 implements Test {
    public void meth1() {
        System.out.println("Hello from meth1");
    }

    public void meth2() {
        System.out.println("Hello from meth2");
    }

    public void meth3() {
        System.out.println("Hello from meth3");
    }
}

public class Practice1 {

    public static void main(String[] args) {
        Test t = new Test1();
        Test1 t1 = new Test1();

        t.meth1();
        t.meth2();
        t1.meth3();
    }
}
