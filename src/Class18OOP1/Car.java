package Class18OOP1;

// OOD核心3: 继承Inheritance
// enables a new class (subclass/child) to acquire properties and behaviors (methods/fields) 
// from an existing class (superclass/parent). It promotes code reusability, reduces redundancy,
// and establishes a natural, hierarchical relationship between classes. 
// extends 表示继承
// super(...) 调用父类构造器
// 子类可以复用父类代码
public class Car extends Vehicle {
    public Car(String brand, int speed, int year) {
        super(brand, speed, year);
    }

    // 子类重新实现(re-implement)父类方法
    // 方法名+参数必须都一样
    // 最好要加一个@Override的annotation
    // 常见：toString(), equals()
    @Override
    public void drive(String driverName) {
        System.out.println(driverName + "is driving " + brand + " of year " + getYear() + " is driving at " + speed);
    }

    // 方法名必须一样
    // 方法的参数必须不同
    // Question: 如果我现在手里只有一个Vehicle，而不一定是Car，我可以call这个版本的drive吗？
    public void drive(String driverName, int driverAge) {
        System.out.println(driverName + " who is at age " + driverAge + "is driving " + brand + " of year " + getYear() + " is driving at " + speed);
    }

    // 一般toString()会被用来记录log
    @Override
    public String toString() {
        return "";
    }
}
