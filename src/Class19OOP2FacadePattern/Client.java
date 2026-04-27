package Class19OOP2FacadePattern;

public class Client {
    public static void main(String[] args) {
        IPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade facade = new HomeTheaterFacade(dvd, projector, sound);

        facade.watchMovie();
        facade.endMovie();
    }
}
