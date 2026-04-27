package Class19OOP2FacadePattern;

public class DVDPlayer implements IPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play() {
        System.out.println("DVD Player is PLAYING");
    }

    public void stop() {
        System.out.println("DVD Player is STOPPED");
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }
}
