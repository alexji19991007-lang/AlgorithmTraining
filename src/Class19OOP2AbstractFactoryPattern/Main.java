package Class19OOP2AbstractFactoryPattern;

public class Main {
    public static void main(String[] args) {
        UIFactory factory = new WindowsFactory();
        // 👉 保证：
        // ✔ btn 和 cb 是同一风格
        // ✔ 不会混用（比如 WindowsButton + MacCheckbox ❌）
        Button btn = factory.createButton();
        Checkbox cb = factory.createCheckbox();
        btn.press();
        cb.flipCheckedStatus();
    }
}
