package Interfaces;

public class Car implements Engine, Brake, Media {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void accelarate() {
        System.out.println("Car engine");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void decelarate() {
        System.out.println("Car decelarate");
    }

    @Override
    public void handBrake() {
        System.out.println("Car handBrake");
    }

}
