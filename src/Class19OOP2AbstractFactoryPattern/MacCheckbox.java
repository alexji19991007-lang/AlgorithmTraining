package Class19OOP2AbstractFactoryPattern;

public class MacCheckbox extends Checkbox {
    @Override
    public void flipCheckedStatus() {
        checkedStatus = !checkedStatus;
        System.out.println("New status for Mac checkbox = " + checkedStatus);
    }
}
