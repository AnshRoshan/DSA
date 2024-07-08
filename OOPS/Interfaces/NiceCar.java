package Interfaces;

public class NiceCar {

    Engine engine;
    private MusicPlayer player = new MusicPlayer();

    public NiceCar() {
        engine = new PowerEngine();
    }

    public NiceCar(Engine engine) {
        this.engine = (engine);
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void startMusic() {
        player.start();
    }

    public void stopMusic() {
        player.stop();
    }

    // learn about class casting
    // conversion of one class to another
    public void batteryInfo() {
        ((BatteryEngine) engine).useBattery();
        // ElectricEngine.useBattery();
    }

    public void upgradeEngine() {
        this.engine = new ElectricEngine();
    }
}
