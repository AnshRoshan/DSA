package Java.OOPS.Interfaces;

public class ElectricEngine implements BatteryEngine {

    @Override
    public void accelarate() {
        System.out.println(" Electric Car engine");
    }

    @Override
    public void decelarate() {
        System.out.println("Electric Car decelarate");
    }

    @Override
    public void start() {
        System.out.println("Electric Car started");
    }

    @Override
    public void stop() {
        System.out.println("Electric Car stopped");
    }

    @Override
    public void charge() {
        System.out.println("Electric Car charged");
    }

    @Override
    public void discharge() {
        System.out.println("Electric Car discharged");
    }

    @Override
    public void useBattery() {
        System.out.println("Electric Car using battery");
    }

}
