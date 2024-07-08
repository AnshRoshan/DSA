package Interfaces;

public class Main {

    public static void main(String[] args) {

        // Car car1 = (Car) new Engine();
        // Creating objects
        Engine car1 = new Car();
        car1.start();
        car1.stop();
        car1.accelarate();
        car1.decelarate();
        Brake.stop();
        // car1.handBrake();

        // this is problem as stoping media will stop the car
        Media car3 = new Car();
        car3.start();
        car3.stop();

        Media car2 = new MusicPlayer();
        car2.start();
        car2.stop();

        // nice car use
        NiceCar niceCar = new NiceCar();
        System.out.println(Engine.getPRICE());
        // niceCar.batteryInfo();
        niceCar.start();
        niceCar.stop();
        niceCar.startMusic();
        niceCar.stopMusic();
        niceCar.upgradeEngine();
        niceCar.start();
        niceCar.stop();
        niceCar.batteryInfo();

    }
}
