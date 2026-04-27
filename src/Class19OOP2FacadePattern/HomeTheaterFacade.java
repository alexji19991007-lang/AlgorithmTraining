package Class19OOP2FacadePattern;

public class HomeTheaterFacade {
    private final IPlayer player;
    private final Projector projector;
    private final SoundSystem soundSystem;

    // Another very important concept here: 
    // DEPENDENCY INJECTION -- 依赖注入
    // 👉 特点：
    // 1. 依赖由外部提供（而不是内部 new）
    // 2. class本身不负责创建依赖
    public HomeTheaterFacade(IPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
        // 如果我们没用Dependency Injection (DI)的话：
        // this.player = new DVDPlayer(); 
        // 1. 无法替换实现 (what if we want this.player = new StreamingPlayer())
        // 2. 难测试
        // 3. 强依赖具体类
        this.player = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie() {
        System.out.println("=== Starting Movie ===");

        projector.on();
        projector.setWideScreenMode();

        soundSystem.on();
        soundSystem.setVolume(10);

        player.on();
        player.play();
    }

    public void endMovie() {
        System.out.println("=== Ending Movie ===");

        player.stop();
        player.off();

        soundSystem.off();

        projector.off();
    }
}
