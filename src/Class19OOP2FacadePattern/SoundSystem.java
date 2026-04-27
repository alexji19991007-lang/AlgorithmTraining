package Class19OOP2FacadePattern;

public class SoundSystem {
    public void on() {
        System.out.println("Sound System is ON");
    }

    public void off() {
        System.out.println("Sound System is OFF");
    }

    public void setVolume(int level) {
        System.out.println("Sound volume set to " + level);
    }
}
