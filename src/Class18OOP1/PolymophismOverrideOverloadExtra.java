package Class18OOP1;

public class PolymophismOverrideOverloadExtra {
    // Overloading 看 reference type（编译期）
    // Overriding 看 instance type（运行期）
    // Reference类型（左手边）决定什么可以调⽤，Instance类型（实际右手边new出来的东西）决定调⽤的具体⽅法的⾏为
    // 先看reference决定使⽤哪个函数的signature.
    // 再看implementation决定使⽤哪个函数版本(function body)
    public static void main(String[] args) {
        // OOD核心3: 多态Polymophism:
        // Allowing objects of different types to be treated as instances of a common 
        // superclass or interface. It enables a single interface to represent different 
        // underlying data types, allowing one function or method to operate on diverse 
        // objects, with each object implementing the behavior in its own way.
        Car normalCar = new Car("Honda", 100, 2021);
        Tesla teslaCar = new Tesla(100, 2025);
        DriveVehicle(normalCar);
        DriveVehicle(teslaCar);
        ChargeVehicle(teslaCar);

        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b)); // A and A
        System.out.println("2--" + a1.show(c)); // A and A
        System.out.println("3--" + a1.show(d)); // A and D
        System.out.println("4--" + a2.show(b)); // B and A
        System.out.println("5--" + a2.show(c)); // B and A
        System.out.println("6--" + a2.show(d)); // A and D
        System.out.println("7--" + b.show(b)); // B and B
        System.out.println("8--" + b.show(c)); // B and B
        System.out.println("9--" + b.show(d)); // A and D
    }

    public static void DriveVehicle(Vehicle myVehicle) {
        myVehicle.drive("Alex");
    }

    public static void ChargeVehicle(IChargeable electicVehicle) {
        electicVehicle.charge();
    }
}

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}

class B extends A {
    // 这里有一个隐形的method
    // public String show(D obj) {
    //     return ("A and D");
    // }

    public String show(B obj) {
        return ("B and B");
    }

    @Override
    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {}

class D extends B {}