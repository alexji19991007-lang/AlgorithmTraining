package Class18OOP1;

public interface IChargeable {
    public static final int MaxCharge = 100; // Interface can only have public static final fields.

    // 不要用
    default void charge() {
        System.out.println("xxx");
    }
}
