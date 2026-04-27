package Class19OOP2FactoryPattern;

public class Main {
    private static final ShapeFactory shapeFactory = new ShapeFactory();

    public static void main(String[] args) {
        Shape shape1 = shapeFactory.createShape("Circle");
        shape1.draw();
        Shape shape2 = shapeFactory.createShape("Square");
        shape2.draw();
        Shape shape3 = shapeFactory.createShape("Rectangle");
        shape3.draw();
    }
}
