package Class18OOP1;

public class Tesla extends Car implements IChargeable, IAutoDriveable {
    // final有两层意思：
    // 1. 在constructor结束以前必须initialize/赋值
    // 2. initialize以后就不能修改了
    private final String CEO;

    public Tesla(int speed, int year) {
        super("Tesla", speed, year);
        this.CEO = "Elon Musk";
    }

    @Override
    public void drive(String driverName) {
        System.out.println("Tesla is driving silently at speed " + speed + " by " + driverName);
    }

    @Override
    public void charge() {
        System.out.println("Charging Tesla... Max charge: " + MaxCharge);
    }

    @Override
    public void AutoDrive() {
        System.out.println("Tesla is auto-driving!!");
    }
}
