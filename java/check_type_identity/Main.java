
class A {

}

class B {

}

class C extends B {

}

public class Main {
    public static void main(String[] argv) {
        System.out.println("Salutare");

        A a = new A();
        B b = new B();
        C c = new C();

        if (a.getClass() == A.class) {
            System.out.println("a's class is A");
        }

        System.out.println("b is of class " + b.getClass().getName());

        if (c instanceof C) {
            System.out.println("c is an object derived from C");
        }
    }
}
