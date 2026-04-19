package Class18OOP1;

import java.util.*;

// OOD核心1: 封装（Encapsulation）
//      - public：任何地方可访问
//      - protected：子类 + 同包
//      - private：仅本类

// OOD核心2: 抽象类 (Abstraction)
//      - Abtract class cannot be instantiated (i.e. you cannot new it)
//      - It can have: abstract methods, normal methods
//      - Used for defining a template
// NOTE: Concrete class cannot have abstract methods. Abstract class doesn't necessarily need to have abstract methods. 
public abstract class Vehicle { 
    // base class -- 应该拥有所有vehicle该有的东西
    // 所有这个class的non-static fields都代表了这个class的state/状态，又可以被称为instance variables。
    public String brand; // 所有人都能访问
    protected double speed; // 子类可访问
    private int year; // 只能本类访问

    public Vehicle(String brand, int speed, int year) {
        this.brand = brand;
        this.speed = speed;
        this.year = year;
    }

    // 通过 public method 访问 private
    public int getYear() { 
        return year;
    }

    // 通过 public method 修改 protected
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // This is an abstract method that does not have any implemetations
    public abstract void drive(String driverName);
}
