package Class18OOP1;

public class Tesla extends Car implements IChargeable, IAutoDriveable {
    public Tesla(int speed, int year) {
        super("Tesla", speed, year);
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
