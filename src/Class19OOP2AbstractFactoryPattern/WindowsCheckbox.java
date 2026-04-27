package Class19OOP2AbstractFactoryPattern;

public class WindowsCheckbox extends Checkbox {
    @Override
    public void flipCheckedStatus() {
        checkedStatus = !checkedStatus;
        System.out.println("New status for windows checkbox = " + checkedStatus);
    }
}
